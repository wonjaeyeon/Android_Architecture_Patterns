package com.android_application_architecture.android_architecture_patterns.ui.feature.reply.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android_application_architecture.android_architecture_patterns.ui.feature.reply.ReplyHomeUIState
import com.android_application_architecture.android_architecture_patterns.ui.window.ReplyContentType

@Composable
fun ReplySinglePaneContent(
    replyHomeUIState: ReplyHomeUIState,
    toggleEmailSelection: (Long) -> Unit,
    emailLazyListState: LazyListState,
    modifier: Modifier = Modifier,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, ReplyContentType) -> Unit
) {
    if (replyHomeUIState.openedEmail != null && replyHomeUIState.isDetailOnlyOpen) {
        BackHandler {
            closeDetailScreen()
        }
        ReplyEmailDetail(email = replyHomeUIState.openedEmail) {
            closeDetailScreen()
        }
    } else {
        ReplyEmailList(
            emails = replyHomeUIState.emails,
            openedEmail = replyHomeUIState.openedEmail,
            selectedEmailIds = replyHomeUIState.selectedEmails,
            toggleEmailSelection = toggleEmailSelection,
            emailLazyListState = emailLazyListState,
            modifier = modifier,
            navigateToDetail = navigateToDetail
        )
    }
}
