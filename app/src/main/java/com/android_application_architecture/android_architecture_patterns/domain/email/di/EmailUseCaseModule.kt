package com.android_application_architecture.android_architecture_patterns.domain.email.di

import com.android_application_architecture.android_architecture_patterns.data.email.repository.EmailRepository
import com.android_application_architecture.android_architecture_patterns.domain.email.usecase.GetEmailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EmailUseCaseModule {


    @Provides
    @Singleton
    fun provideGetEmailUseCases(
        emailModelRepository: EmailRepository
    ) = GetEmailUseCase(emailModelRepository)
}