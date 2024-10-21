package com.android_application_architecture.android_architecture_patterns.data.util

import kotlinx.coroutines.flow.Flow

/**
 * Reports on if synchronization is in progress
 */
interface SyncManager {
    val isSyncing: Flow<Boolean>
    fun requestSync()
}
