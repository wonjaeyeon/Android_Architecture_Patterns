package com.android_application_architecture.android_architecture_patterns.domain.email.usecase

import com.android_application_architecture.android_architecture_patterns.data.email.data_source.local.database.MailboxType
import com.android_application_architecture.android_architecture_patterns.data.email.repository.EmailRepository
import javax.inject.Inject

class GetEmailUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    fun getAllEmails() = emailRepository.getAllEmails()

    fun getCategoryEmails(category: MailboxType) = emailRepository.getCategoryEmails(category)

    fun getAllFolders() = emailRepository.getAllFolders()

    fun getEmailFromId(id: Long) = emailRepository.getEmailFromId(id)
}
