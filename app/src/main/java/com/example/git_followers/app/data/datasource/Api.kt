package com.example.git_followers.app.data.datasource

import Followers
import com.example.git_followers.app.data.datasource.models.UserResultSearchName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// test  https://api.github.com/search/users?q=Q

interface Api {

    @GET("users/{user}/repos")
    suspend fun loadUsers(@Path("user") user: String):Response<UserResultSearchName>

    @GET("search/users?q=Q")
    suspend fun testLoad(): Response<UserResultSearchName>

    @GET("users/{url}/followers")
    suspend fun loadFollowers(@Path("url") url:String): Response<Array<Followers>>
}

