package com.android_application_architecture.android_architecture_patterns.domain.account.usecases

import com.android_application_architecture.android_architecture_patterns.data.account.repository.AccountRepository
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    fun getDefaultUserAccount() = accountRepository.getDefaultUserAccount()

    fun getAllUserAccounts() = accountRepository.getAllUserAccounts()

    fun getContactAccountByUid(uid: Long) = accountRepository.getContactAccountByUid(uid)
}