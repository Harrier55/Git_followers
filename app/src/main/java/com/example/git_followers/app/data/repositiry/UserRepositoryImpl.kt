package com.example.git_followers.app.data.repositiry

import com.example.git_followers.app.data.datasource.ApiStatus
import com.example.git_followers.app.data.datasource.WebRequest
import com.example.git_followers.app.data.mapper.Mapper
import com.example.git_followers.app.domain.IUserSearchUseCase
import com.example.git_followers.app.domain.models.RepositoryResult
import com.example.git_followers.app.domain.models.UserEntity
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(private val webRequest: WebRequest) : IUserSearchUseCase {

    private var userEntity:UserEntity? = null
    override suspend fun getUser(userName: String) = flow {
        if (userEntity?.userName?.isNotEmpty() == true && userEntity?.userName == userName) {
            emit(RepositoryResult.Success(userEntity))
        } else {
            val result = webRequest.loadDataFromServer(userName = userName)
            when (result.status) {
                ApiStatus.ERROR -> {}
                ApiStatus.SUCCESS -> {
                    result.data?.let { userResult ->
                        val countFollowers = calculateFollowers(user = userName)
                        userResult.let {
                            val userEntityRes = Mapper.mapToUserEntity(it,countFollowers)
                            userEntity = userEntityRes
                            emit(RepositoryResult.Success(_data = userEntity))
                        }
                    }
                }
                ApiStatus.LOADING -> {}
            }
        }
    }

    private suspend fun calculateFollowers(user: String): Int {
        return webRequest.loadDataFollowersFromServer(user = user)
    }

}