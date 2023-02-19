package com.example.git_followers.app.presentation.viewmodel

import com.example.git_followers.app.domain.models.UserEntity

data class MainScreenViewState(
    val userEntity: UserEntity,
    val isLoading: Boolean
)
