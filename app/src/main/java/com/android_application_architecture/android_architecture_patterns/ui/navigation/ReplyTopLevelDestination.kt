package com.android_application_architecture.android_architecture_patterns.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class ReplyTopLevelDestination(
    val route: Route,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)