package com.android_application_architecture.android_architecture_patterns.ui.view_models.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_application_architecture.android_architecture_patterns.data.model.article.Article
import com.android_application_architecture.android_architecture_patterns.data.repository.ArticleModelRepository
import com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles.GetArticleUseCases
import com.android_application_architecture.android_architecture_patterns.domain.use_cases.articles.InsertArticleUseCases
import com.android_application_architecture.android_architecture_patterns.ui.view_models.articles.ArticleUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val getArticleUseCases: GetArticleUseCases,
    private val insertArticleUseCases: InsertArticleUseCases
) : ViewModel() {

    val uiState: StateFlow<ArticleUiState>
    = getArticleUseCases.getAllArticles()
        .map<List<Article>, ArticleUiState> { articles ->
            Success(articles.map { it.title })
        }.catch { throwable ->
            emit(ArticleUiState.Error(throwable))
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ArticleUiState.Loading)

    fun addArticle(article: Article, body: String, authorId: Long, authorDateOfBirth: String) {
        viewModelScope.launch {
            insertArticleUseCases.addArticle(article, authorId, authorDateOfBirth)
        }
    }
}


//@HiltViewModel
//class ArticleViewModel @Inject constructor(
//    private val articleModelRepository: ArticleModelRepository,
//) : ViewModel() {
//
//    val uiState: StateFlow<ArticleUiState>
//            = articleModelRepository.allArticles
//        .map<List<Article>, ArticleUiState> { articles ->
//            Success(articles.map { it.title })
//        }.catch { throwable ->
//            emit(ArticleUiState.Error(throwable))
//        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ArticleUiState.Loading)
//
//    fun addArticle(article: Article, body: String, authorId: Long, authorDateOfBirth: String) {
//        viewModelScope.launch {
//            articleModelRepository.add(article, authorId, authorDateOfBirth)
//        }
//    }
//}