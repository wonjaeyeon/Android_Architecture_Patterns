package com.android_application_architecture.android_architecture_patterns.data.user.model

import com.android_application_architecture.android_architecture_patterns.data.theme.model.DarkThemeConfig
import com.android_application_architecture.android_architecture_patterns.data.theme.model.ThemeBrand

/**
 * Class summarizing user interest data
 */
data class UserData(
    val bookmarkedNewsResources: Set<String>,
    val viewedNewsResources: Set<String>,
    val followedTopics: Set<String>,
    val themeBrand: ThemeBrand,
    val darkThemeConfig: DarkThemeConfig,
    val useDynamicColor: Boolean,
    val shouldHideOnboarding: Boolean,
)