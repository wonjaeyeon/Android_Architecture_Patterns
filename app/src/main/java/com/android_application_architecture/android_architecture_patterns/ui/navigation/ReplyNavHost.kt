package com.android_application_architecture.android_architecture_patterns.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import androidx.window.layout.DisplayFeature
import com.android_application_architecture.android_architecture_patterns.ui.feature.article.ArticlesScreen
import com.android_application_architecture.android_architecture_patterns.ui.feature.empty.EmptyComingSoon
import com.android_application_architecture.android_architecture_patterns.ui.feature.reply.ReplyInboxScreen
import com.android_application_architecture.android_architecture_patterns.ui.feature.setting.*
import com.android_application_architecture.android_architecture_patterns.ui.window.ReplyContentType
import com.android_application_architecture.android_architecture_patterns.ui.window.ReplyNavigationType

@Composable
fun ReplyNavHost(
    navController: NavHostController,
    contentType: ReplyContentType,
    displayFeatures: List<DisplayFeature>,
    navigationType: ReplyNavigationType,
    modifier: Modifier = Modifier,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Inbox,
    ) {
        composable<Route.Inbox> {

//            val replyHomeViewModel = ReplyHomeViewModel(
//                getEmailUseCase = GetEmailUseCase(emailRepository = EmailRepositoryImpl())
//            )

            ReplyInboxScreen(
                contentType = contentType,
                //replyHomeViewModel = replyHomeViewModel,
                navigationType = navigationType,
                displayFeatures = displayFeatures,
            )
        }
        composable<Route.DirectMessages> {
            EmptyComingSoon()
        }
        composable<Route.Articles> {
            ArticlesScreen(modifier = Modifier.padding(16.dp),)
        }
        composable<Route.Groups> {
            EmptyComingSoon()
        }

        composable<Route.Settings> {
            FirstSettingScreen()
        }

    }
}
