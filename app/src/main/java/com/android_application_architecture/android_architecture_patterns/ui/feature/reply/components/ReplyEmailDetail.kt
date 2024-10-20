package com.android_application_architecture.android_architecture_patterns.ui.feature.reply.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android_application_architecture.android_architecture_patterns.data.email.model.Email
import com.android_application_architecture.android_architecture_patterns.ui.components.app_bar.EmailDetailAppBar
import com.android_application_architecture.android_architecture_patterns.ui.components.card.ReplyEmailThreadItem


@Composable
fun ReplyEmailDetail(
    email: Email,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = true,
    onBackPressed: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        item {
            EmailDetailAppBar(email, isFullScreen) {
                onBackPressed()
            }
        }
        items(items = email.threads, key = { it.id }) { email ->
            ReplyEmailThreadItem(email = email)
        }
        item {
            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
        }
    }
}
