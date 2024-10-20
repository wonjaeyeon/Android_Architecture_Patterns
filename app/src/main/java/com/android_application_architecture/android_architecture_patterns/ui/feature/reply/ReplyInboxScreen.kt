package com.android_application_architecture.android_architecture_patterns.ui.feature.reply

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.window.layout.DisplayFeature
import com.android_application_architecture.android_architecture_patterns.R
import com.android_application_architecture.android_architecture_patterns.ui.feature.reply.components.ReplyEmailDetail
import com.android_application_architecture.android_architecture_patterns.ui.feature.reply.components.ReplyEmailList
import com.android_application_architecture.android_architecture_patterns.ui.feature.reply.components.ReplySinglePaneContent
import com.android_application_architecture.android_architecture_patterns.ui.window.ReplyContentType
import com.android_application_architecture.android_architecture_patterns.ui.window.ReplyNavigationType
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane


@Composable
fun ReplyInboxScreen(
    contentType: ReplyContentType,
    replyHomeViewModel: ReplyHomeViewModel = hiltViewModel(),
    navigationType: ReplyNavigationType,
    displayFeatures: List<DisplayFeature>,
    modifier: Modifier = Modifier
) {


    val replyHomeUIState by replyHomeViewModel.uiState.collectAsState()

    fun closeDetailScreen(): () -> Unit = {
        replyHomeViewModel.closeDetailScreen()
    }

    fun navigateToDetail(): (Long, ReplyContentType) -> Unit = { emailId, contentType ->
        replyHomeViewModel.setOpenedEmail(emailId, contentType)
    }

    fun toggleSelectedEmail(): (Long) -> Unit = { emailId ->
        replyHomeViewModel.toggleSelectedEmail(emailId)
    }

    /**
     * When moving from LIST_AND_DETAIL page to LIST page clear the selection and user should see LIST screen.
     */
    LaunchedEffect(key1 = contentType) {
        if (contentType == ReplyContentType.SINGLE_PANE && !replyHomeUIState.isDetailOnlyOpen) {
            closeDetailScreen()
        }
    }

    val emailLazyListState = rememberLazyListState()

    // TODO: Show top app bar over full width of app when in multi-select mode

    if (contentType == ReplyContentType.DUAL_PANE) {
        TwoPane(
            first = {
                ReplyEmailList(
                    emails = replyHomeUIState.emails,
                    openedEmail = replyHomeUIState.openedEmail,
                    selectedEmailIds = replyHomeUIState.selectedEmails,
                    toggleEmailSelection = toggleSelectedEmail(),
                    emailLazyListState = emailLazyListState,
                    navigateToDetail = navigateToDetail()
                )
            },
            second = {
                ReplyEmailDetail(
                    email = replyHomeUIState.openedEmail ?: replyHomeUIState.emails.first(),
                    isFullScreen = false
                )
            },
            strategy = HorizontalTwoPaneStrategy(splitFraction = 0.7f, gapWidth = 16.dp),
            displayFeatures = displayFeatures
        )
    } else {
        Box(modifier = modifier.fillMaxSize()) {
            ReplySinglePaneContent(
                replyHomeUIState = replyHomeUIState,
                toggleEmailSelection = toggleSelectedEmail(),
                emailLazyListState = emailLazyListState,
                modifier = Modifier.fillMaxSize(),
                closeDetailScreen = closeDetailScreen(),
                navigateToDetail = navigateToDetail()
            )
            // When we have bottom navigation, we show FAB at the bottom end.
            if (navigationType == ReplyNavigationType.BOTTOM_NAVIGATION) {
                ExtendedFloatingActionButton(
                    text = { Text(text = stringResource(id = R.string.compose)) },
                    icon = { Icon(Icons.Default.Edit, stringResource(id = R.string.compose)) },
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp),
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    expanded = emailLazyListState.lastScrolledBackward ||
                            !emailLazyListState.canScrollBackward
                )
            }
        }
    }
}