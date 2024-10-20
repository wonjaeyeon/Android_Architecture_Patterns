package com.android_application_architecture.android_architecture_patterns.data.account.repository.di


import com.android_application_architecture.android_architecture_patterns.data.account.repository.AccountRepository
import com.android_application_architecture.android_architecture_patterns.data.account.repository.AccountRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountRepositoryModule {


    @Provides
    @Singleton
    fun provideAccountRepository(
    ): AccountRepository { return AccountRepositoryImpl();}
}