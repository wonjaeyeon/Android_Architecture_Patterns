package com.android_application_architecture.android_architecture_patterns.data.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.compose.ui.util.trace
import com.android_application_architecture.android_architecture_patterns.common.network.Dispatcher
import com.android_application_architecture.android_architecture_patterns.common.network.NiaDispatchers
import com.android_application_architecture.android_architecture_patterns.common.network.di.ApplicationScope
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import java.time.ZoneId
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import kotlinx.coroutines.flow.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toKotlinTimeZone
/**
 * Utility for reporting current timezone the device has set.
 * It always emits at least once with default setting and then for each TZ change.
 */
interface TimeZoneMonitor {
    val currentTimeZone: Flow<TimeZone>
}

@Singleton
internal class TimeZoneBroadcastMonitor @Inject constructor(
    @ApplicationContext private val context: Context,
    @ApplicationScope appScope: CoroutineScope,
    @Dispatcher(NiaDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : TimeZoneMonitor {

    override val currentTimeZone: SharedFlow<TimeZone> =
        callbackFlow {
            // Send the default time zone first.
            trySend(TimeZone.currentSystemDefault())

            // Registers BroadcastReceiver for the TimeZone changes
            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    if (intent.action != Intent.ACTION_TIMEZONE_CHANGED) return

                    val zoneIdFromIntent = if (VERSION.SDK_INT < Build.VERSION_CODES.R) {
                        null
                    } else {
                        // Starting Android R we also get the new TimeZone.
                        intent.getStringExtra(Intent.EXTRA_TIMEZONE)?.let { timeZoneId ->
                            // We need to convert it from java.util.Timezone to java.time.ZoneId
                            val zoneId = ZoneId.of(timeZoneId, ZoneId.SHORT_IDS)
                            // Convert to kotlinx.datetime.TimeZone
                            zoneId.toKotlinTimeZone()
                        }
                    }

                    // If there isn't a zoneId in the intent, fallback to the systemDefault, which should also reflect the change
                    trySend(zoneIdFromIntent ?: TimeZone.currentSystemDefault())
                }
            }

            trace("TimeZoneBroadcastReceiver.register") {
                context.registerReceiver(receiver, IntentFilter(Intent.ACTION_TIMEZONE_CHANGED))
            }

            // Send here again, because registering the Broadcast Receiver can take up to several milliseconds.
            // This way, we can reduce the likelihood that a TZ change wouldn't be caught with the Broadcast Receiver.
            trySend(TimeZone.currentSystemDefault())

            awaitClose {
                context.unregisterReceiver(receiver)
            }
        }
            // We use to prevent multiple emissions of the same type, because we use trySend multiple times.
            .distinctUntilChanged()
            .conflate()
            .flowOn(ioDispatcher)
            // Sharing the callback to prevent multiple BroadcastReceivers being registered
            .shareIn(appScope, SharingStarted.WhileSubscribed(5_000), 1)
}
