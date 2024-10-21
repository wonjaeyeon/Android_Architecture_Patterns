package com.android_application_architecture.android_architecture_patterns.data.user_search_result.model

import com.android_application_architecture.android_architecture_patterns.data.topic.model.FollowableTopic

/**
 * An entity of [SearchResult] with additional user information such as whether the user is
 * following a topic.
 */
data class UserSearchResult(
    val topics: List<FollowableTopic> = emptyList(),
    val newsResources: List<UserNewsResource> = emptyList(),
)
