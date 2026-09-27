package com.example.myapplication.core

sealed class ApiResult<out T> {

    data class Success<T>(
        val data: T
    ) : ApiResult<T>()

    data class Error(
        val error: AppError
    ) : ApiResult<Nothing>()
}

