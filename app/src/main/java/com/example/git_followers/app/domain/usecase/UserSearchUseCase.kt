package com.example.git_followers.app.domain.usecase
import com.example.git_followers.app.data.repositiry.UserRepositoryImpl
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserEntity
import kotlinx.coroutines.flow.Flow

class UserSearchUseCase(private val userRepository: UserRepositoryImpl){
     suspend fun getUser(userName: String): Flow<RepositoryResult<UserEntity>>{
        return userRepository.getUser(userName = userName)

     }

}


