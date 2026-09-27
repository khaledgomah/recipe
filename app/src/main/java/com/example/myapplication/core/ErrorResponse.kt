package com.example.myapplication.core

sealed interface AppError {

    data object NoInternet : AppError

    data object ServerError : AppError

    data object Unauthorized : AppError

    data class BackendError(
        val message: String,
        val code: Int? = null
    ) : AppError

    data object Unknown : AppError
}




