package com.android_application_architecture.android_architecture_patterns.domain.use_cases.dependency_injection

import com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article.ArticleDataBaseModelDao
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepository
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepositoryImpl
import com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles.GetArticleUseCases
import com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles.InsertArticleUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetArticleUseCases(
        articleModelRepository: ArticleModelRepository
    ) = GetArticleUseCases(articleModelRepository)

    @Provides
    @Singleton
    fun provideInsertArticleUseCases(
        articleModelRepository: ArticleModelRepository
    ) = InsertArticleUseCases(articleModelRepository)
}