package com.android_application_architecture.android_architecture_patterns.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Search
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.android_application_architecture.android_architecture_patterns.R
import kotlinx.serialization.Serializable


sealed interface Route {
    @Serializable data object Inbox : Route
    @Serializable data object Articles : Route
    @Serializable data object DirectMessages : Route
    @Serializable data object Groups : Route
    @Serializable data object Settings : Route
}



class ReplyNavigationActions(private val navController: NavHostController) {

    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

// used with for loop for making navigation components
val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = Route.Inbox,
        selectedIcon = Icons.Default.Info,
        unselectedIcon = Icons.Default.Info,
        iconTextId = R.string.tab_inbox
    ),
    TopLevelDestination(
        route = Route.Articles,
        selectedIcon = Icons.Filled.CheckCircle,
        unselectedIcon = Icons.Filled.CheckCircle,
        iconTextId = R.string.tab_article
    ),
    TopLevelDestination(
        route = Route.DirectMessages,
        selectedIcon = Icons.Outlined.Search,
        unselectedIcon = Icons.Outlined.Search,
        iconTextId = R.string.tab_inbox
    ),
    TopLevelDestination(
        route = Route.Groups,
        selectedIcon = Icons.Default.Menu,
        unselectedIcon = Icons.Default.Menu,
        iconTextId = R.string.tab_article
    ),
    TopLevelDestination(
        route = Route.Settings, // Add Settings to the top-level destinations
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        iconTextId = R.string.tab_settings // Assuming you have this string resource
    )

)
