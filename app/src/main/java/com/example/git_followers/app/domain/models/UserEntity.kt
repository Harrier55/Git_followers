package com.example.git_followers.app.domain.models

data class UserEntity(
    val id: Int?                 = null,
    val userName: String?        = null,
    val userImageUrl: String?    = null,
    val userNumFollowers: Int    = 0
)