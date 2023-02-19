package com.example.git_followers.app.domain
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserEntity
import kotlinx.coroutines.flow.Flow

internal interface IUserRepositoryUseCase{

    suspend fun getUser(userName: String): Flow<RepositoryResult<UserEntity>>

}


