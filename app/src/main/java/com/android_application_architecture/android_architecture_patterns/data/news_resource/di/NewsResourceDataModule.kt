package com.android_application_architecture.android_architecture_patterns.data.news_resource.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsResourceDataModule {
    @Binds
    fun bindsUserNewsResourceRepository(
        userDataRepository: CompositeUserNewsResourceRepository,
    ): UserNewsResourceRepository
}