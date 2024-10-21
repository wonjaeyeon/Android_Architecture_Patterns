package com.android_application_architecture.android_architecture_patterns.data.sync.di.demo

import com.android_application_architecture.android_architecture_patterns.data.sync.status.StubSyncSubscriber
import com.android_application_architecture.android_architecture_patterns.data.sync.status.SyncSubscriber
import com.android_application_architecture.android_architecture_patterns.data.sync.status.WorkManagerSyncManager
import com.android_application_architecture.android_architecture_patterns.data.util.SyncManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SyncModule {
    @Binds
    internal abstract fun bindsSyncStatusMonitor(
        syncStatusMonitor: WorkManagerSyncManager,
    ): SyncManager

    @Binds
    internal abstract fun bindsSyncSubscriber(
        syncSubscriber: StubSyncSubscriber,
    ): SyncSubscriber

//    companion object {
//        @Provides
//        @Singleton
//        internal fun provideFirebaseMessaging(): FirebaseMessaging = Firebase.messaging
//    }
}
