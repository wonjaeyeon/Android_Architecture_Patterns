package com.android_application_architecture.android_architecture_patterns.ui.router

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android_application_architecture.android_architecture_patterns.ui.view_models.articles.ArticleViewModel
import com.android_application_architecture.android_architecture_patterns.ui.views.articles.ArticlesScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { ArticlesScreen(modifier = Modifier.padding(16.dp), ) }
        // TODO: Add more destinations
    }
}
