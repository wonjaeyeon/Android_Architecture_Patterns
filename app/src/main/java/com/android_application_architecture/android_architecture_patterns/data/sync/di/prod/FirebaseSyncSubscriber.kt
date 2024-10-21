package com.android_application_architecture.android_architecture_patterns.data.sync.di.prod

import com.android_application_architecture.android_architecture_patterns.data.sync.initializers.SYNC_TOPIC
import com.android_application_architecture.android_architecture_patterns.data.sync.status.SyncSubscriber
import javax.inject.Inject

///**
// * Implementation of [SyncSubscriber] that subscribes to the FCM [SYNC_TOPIC]
// */
//internal class FirebaseSyncSubscriber @Inject constructor(
//    private val firebaseMessaging: FirebaseMessaging,
//) : SyncSubscriber {
//    override suspend fun subscribe() {
//        firebaseMessaging
//            .subscribeToTopic(SYNC_TOPIC)
//            .await()
//    }
//}
