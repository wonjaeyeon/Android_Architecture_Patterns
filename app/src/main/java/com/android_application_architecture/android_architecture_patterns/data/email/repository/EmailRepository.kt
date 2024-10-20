package com.android_application_architecture.android_architecture_patterns.data.email.repository

import com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.database.MailboxType
import com.android_application_architecture.android_architecture_patterns.data.email.model.Email
import kotlinx.coroutines.flow.Flow

/**
 * An Interface contract to get all emails info for a User.
 */
interface EmailRepository {
    fun getAllEmails(): Flow<List<Email>>
    fun getCategoryEmails(category: MailboxType): Flow<List<Email>>
    fun getAllFolders(): List<String>
    fun getEmailFromId(id: Long): Flow<Email?>
}