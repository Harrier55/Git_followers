package com.example.git_followers.app.data.datasource

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// https://api.github.com/search/users?q=Q

interface Api {

    @GET("users/{user}/repos")
    fun loadUsers(@Path("user") user: String):Call<String>

    @GET("search/users?q=Q")
    suspend fun testLoad(): Response<UserResultSearchName>
}