package com.example.git_followers.app.data.datasource

/** класс обертка для ответов
 * взято здесь https://stackoverflow.com/questions/67812248/elegant-way-of-handling-error-using-retrofit-kotlin-flow*/

sealed class ApiResult<out T>(val status: ApiStatus, val data: T?, val message: String?) {

    data class Success<out R>(val _data: R?) : ApiResult<R>(
        status = ApiStatus.SUCCESS,
        data = _data,
        message = null
    )

    data class Error(val exception: String) : ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = exception
    )

    data class Loading<out R>(val _data: R?, val isLoading: Boolean) : ApiResult<R>(
        status = ApiStatus.LOADING,
        data = _data,
        message = null
    )
}

enum class ApiStatus {
    SUCCESS,
    ERROR,
    LOADING
}