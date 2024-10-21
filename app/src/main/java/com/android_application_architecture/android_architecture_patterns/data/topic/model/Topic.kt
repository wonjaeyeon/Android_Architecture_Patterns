package com.android_application_architecture.android_architecture_patterns.data.topic.model

/**
 * External data layer representation of a NiA Topic
 */
data class Topic(
    val id: String,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val url: String,
    val imageUrl: String,
)
