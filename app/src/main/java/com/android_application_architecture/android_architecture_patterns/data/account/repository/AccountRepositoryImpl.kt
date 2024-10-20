package com.android_application_architecture.android_architecture_patterns.data.account.repository

import com.android_application_architecture.android_architecture_patterns.data.account.data_source.local.di.LocalAccountsDataProvider
import com.android_application_architecture.android_architecture_patterns.data.account.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AccountRepositoryImpl : AccountRepository  {
    override fun getDefaultUserAccount(): Flow<Account> = flow {
        emit(LocalAccountsDataProvider.getDefaultUserAccount())
    }

    override fun getAllUserAccounts(): Flow<List<Account>> = flow {
        emit(LocalAccountsDataProvider.allUserAccounts)
    }

    override fun getContactAccountByUid(uid: Long): Flow<Account> = flow {
        emit(LocalAccountsDataProvider.getContactAccountByUid(uid))
    }
}