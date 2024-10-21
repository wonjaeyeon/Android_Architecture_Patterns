package com.android_application_architecture.android_architecture_patterns.data.topic.data_source.local.database

import com.android_application_architecture.android_architecture_patterns.data.topic.model.Topic
import com.android_application_architecture.android_architecture_patterns.data.util.Syncable
import kotlinx.coroutines.flow.Flow

interface TopicsRepository : Syncable {
    /**
     * Gets the available topics as a stream
     */
    fun getTopics(): Flow<List<Topic>>

    /**
     * Gets data for a specific topic
     */
    fun getTopic(id: String): Flow<Topic>
}