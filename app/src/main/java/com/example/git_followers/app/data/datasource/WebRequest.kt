package com.example.git_followers.app.data.datasource

import android.util.Log
import com.example.git_followers.app.data.datasource.models.UserReposGitHub
import com.example.git_followers.app.data.datasource.models.UserResultSearchName
import retrofit2.HttpException
import java.io.IOException

class WebRequest(private val webApi: Api) {

    suspend fun loadDataUserProjects(userName: String): ApiResult<List<UserReposGitHub>> {
        try {
            val response = webApi.loadUsersWithRepo(userName)
            return if (response.code() == 200 && response.isSuccessful) {
                val data = response.body()
                ApiResult.Success(_data = data)
            } else {
                ApiResult.Error(exception = "server response ${response.code()}")
            }
        } catch (e: HttpException) {
            return ApiResult.Error(exception = "HttpException $e")
        } catch (e: IOException) {
            return ApiResult.Error(exception = "IOException $e")
        } catch (e: Exception) {
            return ApiResult.Error(exception = "Exception $e")
        }
    }

    suspend fun loadDataFromServer(userName: String): ApiResult<UserResultSearchName> {
        try {
            val response = webApi.loadDataUser(users = userName)
            return if (response.code() == 200 && response.isSuccessful) {
                val data = response.body()
                ApiResult.Success(_data = data)
            } else {
                ApiResult.Error(exception = "server response ${response.code()}")
            }
        } catch (e: HttpException) {
            return ApiResult.Error(exception = "HttpException $e")
        } catch (e: IOException) {
            return ApiResult.Error(exception = "IOException $e")
        } catch (e: Exception) {
            return ApiResult.Error(exception = "Exception $e")
        }
    }

    suspend fun loadDataFollowersFromServer(user: String): Int {
        try {
            val response = webApi.loadFollowers(user)
            return response.body()?.size ?: 0
        } catch (e: Exception) {
            Log.d("@@@", "Error loadDataFollowersFromServer: $e")
        }
        return 0
    }
}