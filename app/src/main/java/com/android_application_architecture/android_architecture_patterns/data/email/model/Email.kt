package com.android_application_architecture.android_architecture_patterns.data.email.model

import com.android_application_architecture.android_architecture_patterns.data.account.model.Account
import com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.database.EmailAttachment
import com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.database.MailboxType

/**
 * A simple data class to represent an Email.
 */
data class Email(
    val id: Long,
    val sender: Account,
    val recipients: List<Account> = emptyList(),
    val subject: String,
    val body: String,
    val attachments: List<EmailAttachment> = emptyList(),
    var isImportant: Boolean = false,
    var isStarred: Boolean = false,
    var mailbox: MailboxType = MailboxType.INBOX,
    val createdAt: String,
    val threads: List<Email> = emptyList()
)
