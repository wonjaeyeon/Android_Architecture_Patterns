package com.android_application_architecture.android_architecture_patterns.data.sync.di.prod

import com.android_application_architecture.android_architecture_patterns.data.util.SyncManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//private const val SYNC_TOPIC_SENDER = "/topics/sync"
//
//@AndroidEntryPoint
//internal class SyncNotificationsService : FirebaseMessagingService() {
//
//    @Inject
//    lateinit var syncManager: SyncManager
//
//    override fun onMessageReceived(message: RemoteMessage) {
//        if (SYNC_TOPIC_SENDER == message.from) {
//            syncManager.requestSync()
//        }
//    }
//}
