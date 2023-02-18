package com.example.git_followers.app.data.repositiry
import com.example.git_followers.app.data.datasource.WebRequest
import com.example.git_followers.app.domain.IUserRepositoryUseCase
import com.example.git_followers.app.domain.models.UserEntity
import kotlinx.coroutines.flow.flow


class UserRepositoryImpl(private val webRequest: WebRequest):IUserRepositoryUseCase {

    private val userEntity by lazy { UserEntity() }

     override suspend fun getUser(userName: String)  = flow {


            if (userEntity.userName?.isNotEmpty() == true) {
                emit(userEntity)
            } else {
              val result =  webRequest.loadDataFromServer()


            }


         emit(userEntity)
    }
}