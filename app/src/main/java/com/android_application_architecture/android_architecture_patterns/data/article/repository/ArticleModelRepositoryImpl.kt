package com.android_application_architecture.android_architecture_patterns.data.article.repository

import com.android_application_architecture.android_architecture_patterns.data.article.data_source.local.database.ArticleDataBaseModelDao
import com.android_application_architecture.android_architecture_patterns.data.article.data_source.local.database.toArticle
import com.android_application_architecture.android_architecture_patterns.data.article.data_source.local.database.toArticleDataBaseModel
import com.android_application_architecture.android_architecture_patterns.data.article.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ArticleModelRepositoryImpl  @Inject constructor(
    private val articleDao: ArticleDataBaseModelDao
) : ArticleModelRepository {
    override val allArticles: Flow<List<Article>> =
        articleDao.getArticleDataBaseModels().map { items -> items.map {
            it.toArticle()
        } }

    override suspend fun getArticleModel(id: Int): Flow<Article> {
        return articleDao.getArticleDataBaseModel(id).map { it.toArticle() }
    }

    override suspend fun add(article: Article, authorId: Long, authorDateOfBirth: String) {
        articleDao.insertArticleDataBaseModel(article.toArticleDataBaseModel(authorId, authorDateOfBirth))
    }

    override suspend fun delete(article: Article) {
        articleDao.deleteArticleDataBaseModel(article.uid)
    }
}
