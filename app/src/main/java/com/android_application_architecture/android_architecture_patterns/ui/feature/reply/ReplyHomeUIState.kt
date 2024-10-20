package com.android_application_architecture.android_architecture_patterns.ui.feature.reply

import com.android_application_architecture.android_architecture_patterns.data.email.model.Email

data class ReplyHomeUIState(
    val emails: List<Email> = emptyList(),
    val selectedEmails: Set<Long> = emptySet(),
    val openedEmail: Email? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null
)
