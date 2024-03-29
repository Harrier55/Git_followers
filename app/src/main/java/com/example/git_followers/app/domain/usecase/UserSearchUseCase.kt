package com.example.git_followers.app.domain.usecase
import com.example.git_followers.app.domain.repository.UserRepository
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserEntity
import kotlinx.coroutines.flow.Flow

class UserSearchUseCase(private val userRepository: UserRepository){
     suspend fun execute(userName: String): Flow<RepositoryResult<UserEntity>>{
        return userRepository.getUser(userName = userName)

     }

}


