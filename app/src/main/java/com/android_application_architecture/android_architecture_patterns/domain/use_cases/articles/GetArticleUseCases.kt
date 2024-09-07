package com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles

import com.android_application_architecture.android_architecture_patterns.data.model.article.Article
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetArticleUseCases @Inject constructor(
    private val articleModelRepository: ArticleModelRepository
) {

    fun getAllArticles():
            Flow<List<Article>> =
            articleModelRepository.allArticles

}

