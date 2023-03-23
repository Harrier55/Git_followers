package com.example.git_followers.app.data.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASEURL = "https://api.github.com/"

object Network {
    val webApi = Retrofit.Builder()
    .baseUrl(BASEURL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(Api::class.java)

}