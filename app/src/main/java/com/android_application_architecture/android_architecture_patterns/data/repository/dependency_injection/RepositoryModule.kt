package com.android_application_architecture.android_architecture_patterns.data.repository.dependency_injection

import com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article.ArticleDataBaseModelDao
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepository
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideArticleModelRepository(
        articleDao: ArticleDataBaseModelDao
    ): ArticleModelRepository {
        return ArticleModelRepositoryImpl(articleDao)
    }
}