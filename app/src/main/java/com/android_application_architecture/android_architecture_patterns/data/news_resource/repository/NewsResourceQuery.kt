package com.android_application_architecture.android_architecture_patterns.data.news_resource.repository

/**
 * Encapsulation class for query parameters for [NewsResource]
 */
data class NewsResourceQuery(
    /**
     * Topic ids to filter for. Null means any topic id will match.
     */
    val filterTopicIds: Set<String>? = null,
    /**
     * News ids to filter for. Null means any news id will match.
     */
    val filterNewsIds: Set<String>? = null,
)
