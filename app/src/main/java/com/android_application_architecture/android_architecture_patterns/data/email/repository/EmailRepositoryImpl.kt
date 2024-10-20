package com.android_application_architecture.android_architecture_patterns.data.email.repository

import com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.database.MailboxType
import com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.di.LocalEmailsDataProvider
import com.android_application_architecture.android_architecture_patterns.data.email.model.Email
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmailRepositoryImpl : EmailRepository {

    override fun getAllEmails(): Flow<List<Email>> = flow {
        emit(LocalEmailsDataProvider.allEmails)
    }

    override fun getCategoryEmails(category: MailboxType): Flow<List<Email>> = flow {
        val categoryEmails = LocalEmailsDataProvider.allEmails.filter { it.mailbox == category }
        emit(categoryEmails)
    }

    override fun getAllFolders(): List<String> {
        return LocalEmailsDataProvider.getAllFolders()
    }

    override fun getEmailFromId(id: Long): Flow<Email?> = flow {
        val categoryEmails = LocalEmailsDataProvider.allEmails.firstOrNull { it.id == id }
    }
}
