package com.android_application_architecture.android_architecture_patterns.data.news_resource.model

import android.adservices.topics.Topic
import kotlinx.datetime.Instant

/**
 * External data layer representation of a fully populated NiA news resource
 */
data class NewsResource(
    val id: String,
    val title: String,
    val content: String,
    val url: String,
    val headerImageUrl: String?,
    val publishDate: Instant,
    val type: String,
    val topics: List<Topic>,
)
