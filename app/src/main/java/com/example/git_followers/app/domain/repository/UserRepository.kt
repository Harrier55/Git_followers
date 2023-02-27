package com.example.git_followers.app.domain.repository

import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser(userName: String): Flow<RepositoryResult<UserEntity>>

}