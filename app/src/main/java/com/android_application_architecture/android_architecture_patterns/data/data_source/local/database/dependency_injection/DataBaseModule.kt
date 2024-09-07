package com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.dependency_injection

import android.content.Context
import androidx.room.Room
import com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article.ArticleDataBaseModelDao
import com.android_application_architecture.android_architecture_patterns.data.data_source.local.database.article.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideArticleDataBaseModelDao(appDatabase: ArticleDatabase): ArticleDataBaseModelDao {
        return appDatabase.articleDataBaseModelDao()
    }

    @Provides
    @Singleton
    fun provideArticleDatabase(@ApplicationContext appContext: Context): ArticleDatabase {
        return Room.databaseBuilder(
            appContext,
            ArticleDatabase::class.java,
            "ArticleDataBaseModel"
        ).build()
    }
}