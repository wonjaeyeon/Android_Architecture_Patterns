package com.android_application_architecture.android_architecture_patterns.data.sync.workers

import com.android_application_architecture.android_architecture_patterns.core.analytics.AnalyticsEvent
import com.android_application_architecture.android_architecture_patterns.core.analytics.AnalyticsHelper

internal fun AnalyticsHelper.logSyncStarted() =
    logEvent(
        AnalyticsEvent(type = "network_sync_started"),
    )

internal fun AnalyticsHelper.logSyncFinished(syncedSuccessfully: Boolean) {
    val eventType = if (syncedSuccessfully) "network_sync_successful" else "network_sync_failed"
    logEvent(
        AnalyticsEvent(type = eventType),
    )
}
