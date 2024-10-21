package com.android_application_architecture.android_architecture_patterns.data.news_resource.repository

import com.android_application_architecture.android_architecture_patterns.data.news_resource.model.NewsResource
import com.android_application_architecture.android_architecture_patterns.data.util.Syncable
import kotlinx.coroutines.flow.Flow

/**
 * Data layer implementation for [NewsResource]
 */
interface NewsRepository : Syncable {
    /**
     * Returns available news resources that match the specified [query].
     */
    fun getNewsResources(
        query: NewsResourceQuery = NewsResourceQuery(
            filterTopicIds = null,
            filterNewsIds = null,
        ),
    ): Flow<List<NewsResource>>
}
