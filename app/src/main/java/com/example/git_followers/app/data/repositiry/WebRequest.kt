package com.example.git_followers.app.data.repositiry

import com.example.git_followers.app.data.datasource.ApiResult
import com.example.git_followers.app.data.datasource.models.UserReposGitHub
import com.example.git_followers.app.data.datasource.models.UserResultSearchName

interface WebRequest {

    suspend fun loadDataUserProjects(userName: String): ApiResult<List<UserReposGitHub>>
    suspend fun loadDataFromServer(userName: String): ApiResult<UserResultSearchName>
    suspend fun loadDataFollowersFromServer(user: String): Int
}