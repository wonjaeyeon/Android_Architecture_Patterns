package com.android_application_architecture.android_architecture_patterns.data.search_result

import com.android_application_architecture.android_architecture_patterns.data.news_resource.model.NewsResource
import com.android_application_architecture.android_architecture_patterns.data.topic.model.Topic

/** An entity that holds the search result */
data class SearchResult(
    val topics: List<Topic> = emptyList(),
    val newsResources: List<NewsResource> = emptyList(),
)
