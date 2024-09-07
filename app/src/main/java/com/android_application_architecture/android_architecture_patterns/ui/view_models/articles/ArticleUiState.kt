package com.android_application_architecture.android_architecture_patterns.ui.view_models.articles

sealed interface ArticleUiState{
    object Loading : ArticleUiState
    data class Success(val articles: List<String>) : ArticleUiState
    data class Error(val throwable: Throwable) : ArticleUiState
}