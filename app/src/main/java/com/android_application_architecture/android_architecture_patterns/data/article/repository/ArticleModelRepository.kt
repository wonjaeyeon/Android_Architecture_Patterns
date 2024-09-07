package com.android_application_architecture.android_architecture_patterns.data.article.repository

import com.android_application_architecture.android_architecture_patterns.data.article.model.Article
import kotlinx.coroutines.flow.Flow
//

interface ArticleModelRepository {
    val allArticles: Flow<List<Article>>


    suspend fun getArticleModel(id: Int): Flow<Article>

    suspend fun add(article : Article, authorId : Long, authorDateOfBirth : String)

    suspend fun delete(article : Article)
}
