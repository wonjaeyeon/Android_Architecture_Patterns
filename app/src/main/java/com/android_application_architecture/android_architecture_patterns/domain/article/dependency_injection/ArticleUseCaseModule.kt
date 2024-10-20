package com.android_application_architecture.android_architecture_patterns.domain.article.dependency_injection


import com.android_application_architecture.android_architecture_patterns.data.article.repository.ArticleModelRepository
import com.android_application_architecture.android_architecture_patterns.domain.article.use_cases.GetArticleUseCases
import com.android_application_architecture.android_architecture_patterns.domain.article.use_cases.InsertArticleUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleUseCaseModule {

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