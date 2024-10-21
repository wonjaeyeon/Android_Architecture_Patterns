package com.android_application_architecture.android_architecture_patterns.ui

import com.android_application_architecture.android_architecture_patterns.data.user.model.UserData


sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}
