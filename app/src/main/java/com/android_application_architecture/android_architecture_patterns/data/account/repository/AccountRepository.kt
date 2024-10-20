package com.android_application_architecture.android_architecture_patterns.data.account.repository

import com.android_application_architecture.android_architecture_patterns.data.account.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getDefaultUserAccount(): Flow<Account>
    fun getAllUserAccounts(): Flow<List<Account>>
    fun getContactAccountByUid(uid: Long): Flow<Account>
}