package com.example.git_followers.app.domain.models

/** класс обертка для ответов
 * взято здесь https://stackoverflow.com/questions/67812248/elegant-way-of-handling-error-using-retrofit-kotlin-flow*/

sealed class RepositoryResult<out T>(val status: Status, val data: T?, val message: String?) {

    data class Success<out R>(val _data: R?) : RepositoryResult<R>(
        status = Status.SUCCESS,
        data = _data,
        message = null
    )

    data class Error(val error: String) : RepositoryResult<Nothing>(
        status = Status.ERROR,
        data = null,
        message = error
    )

    data class Loading<out R>(val _data: R?, val isLoading: Boolean) : RepositoryResult<R>(
        status = Status.LOADING,
        data = _data,
        message = null
    )
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}