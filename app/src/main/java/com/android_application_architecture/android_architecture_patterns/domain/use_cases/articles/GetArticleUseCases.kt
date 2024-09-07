package com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles


import com.android_application_architecture.android_architecture_patterns.data.article.model.Article
import com.android_application_architecture.android_architecture_patterns.data.article.repository.ArticleModelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticleUseCases @Inject constructor(
    private val articleModelRepository: ArticleModelRepository
) {

    fun getAllArticles():
            Flow<List<Article>> =
            articleModelRepository.allArticles

}

