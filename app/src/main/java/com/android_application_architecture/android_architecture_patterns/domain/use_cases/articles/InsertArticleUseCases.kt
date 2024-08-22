package com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles

import com.android_application_architecture.android_architecture_patterns.data.model.article.Article
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertArticleUseCases @Inject constructor(
    private val articleModelRepository: ArticleModelRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun addArticle(article: Article, authorId: Long, authorDateOfBirth: String) =
        withContext(defaultDispatcher) {
            articleModelRepository.add(article, authorId, authorDateOfBirth)

        }
}
