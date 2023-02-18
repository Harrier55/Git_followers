package com.example.git_followers.app.data.datasource

import android.util.Log
import retrofit2.HttpException
import java.io.IOException

class WebRequest(private val webApi: Api) {

   suspend fun loadDataFromServer(){

       try {
           val response =  webApi.testLoad()
           Log.d("@@@", "loadDataFromServer: ${response.body()}")
       }catch (ex: HttpException){

       }catch (io: IOException){

       }catch (e: Exception){

       }
    }
}