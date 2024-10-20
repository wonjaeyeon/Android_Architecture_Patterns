package com.android_application_architecture.android_architecture_patterns.domain.account.di

import com.android_application_architecture.android_architecture_patterns.data.account.repository.AccountRepository
import com.android_application_architecture.android_architecture_patterns.domain.account.usecases.GetAccountUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountUseCaseModule {

    @Provides
    @Singleton
    fun provideGetAccountUseCases(
        accountRepository: AccountRepository
    ) = GetAccountUseCase(accountRepository)
}