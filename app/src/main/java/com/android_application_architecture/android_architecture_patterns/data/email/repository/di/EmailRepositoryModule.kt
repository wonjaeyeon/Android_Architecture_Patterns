package com.android_application_architecture.android_architecture_patterns.data.email.repository.di

import com.android_application_architecture.android_architecture_patterns.data.email.repository.EmailRepository
import com.android_application_architecture.android_architecture_patterns.data.email.repository.EmailRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EmailRepositoryModule {

    @Provides
    @Singleton
    fun provideEmailRepository(
    ): EmailRepository {
        return EmailRepositoryImpl()
    }
}