package com.example.git_followers.app.data.datasource

import Followers
import com.example.git_followers.app.data.datasource.models.UserReposGitHub
import com.example.git_followers.app.data.datasource.models.UserResultSearchName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



interface Api {

    @GET("users/{user}/repos")
    suspend fun loadUsersWithRepo(@Path("user") user: String):Response<List<UserReposGitHub>>

    @GET("search/users")
    suspend fun loadDataUser(@Query("q") users: String): Response<UserResultSearchName>

    @GET("users/{url}/followers")
    suspend fun loadFollowers(@Path("url") url:String): Response<Array<Followers>>
}

