package com.android_application_architecture.android_architecture_patterns.ui.feature.setting


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android_application_architecture.android_architecture_patterns.ui.navigation.Route
import kotlinx.serialization.Serializable


// Define the routes for the settings
sealed interface SettingRoute {
    @Serializable object MainSettings : SettingRoute
    @Serializable object NotificationSettings : SettingRoute
    @Serializable object PrivacySettings : SettingRoute
}

// Function to add the settings graph
fun NavGraphBuilder.settingsGraph(navController: NavHostController) {
    // Start the graph with MainSettings
    navigation(startDestination = SettingRoute.MainSettings.toString(), route = Route.Settings.toString()) {
        composable(SettingRoute.MainSettings.toString()) {
            MainSettingsScreen(navController)
        }
        composable(SettingRoute.NotificationSettings.toString()) {
            NotificationSettingsScreen(navController)
        }
        composable(SettingRoute.PrivacySettings.toString()) {
            PrivacySettingsScreen(navController)
        }
    }
}

// Main settings screen
@Composable
fun MainSettingsScreen(navController: NavController) {
    // Add your settings UI here
    Column {
        // Button to navigate to Notification Settings
        Button(onClick = { navController.navigate(SettingRoute.NotificationSettings.toString()) }) {
            Text("Notification Settings")
        }
        // Button to navigate to Privacy Settings
        Button(onClick = { navController.navigate(SettingRoute.PrivacySettings.toString()) }) {
            Text("Privacy Settings")
        }
    }
}

// Notification settings screen
@Composable
fun NotificationSettingsScreen(navController: NavController) {
    // UI for notification settings
}

// Privacy settings screen
@Composable
fun PrivacySettingsScreen(navController: NavController) {
    // UI for privacy settings
}