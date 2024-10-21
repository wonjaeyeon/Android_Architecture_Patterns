package com.android_application_architecture.android_architecture_patterns.ui


sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}
