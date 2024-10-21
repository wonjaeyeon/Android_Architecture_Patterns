package com.android_application_architecture.android_architecture_patterns.data.sync.status

/**
 * Subscribes to backend requested synchronization
 */
interface SyncSubscriber {
    suspend fun subscribe()
}
