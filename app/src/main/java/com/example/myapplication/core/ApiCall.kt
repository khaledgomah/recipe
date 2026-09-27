package com.example.myapplication.core

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import java.io.IOException

object ApiCall{
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): ApiResult<T> {

        return try {

            val response = apiCall()

            ApiResult.Success(response)

        } catch (_: IOException) {

            ApiResult.Error(
                AppError.NoInternet
            )

        } catch (e: ClientRequestException) {

            when (e.response.status.value) {

                401 -> {
                    ApiResult.Error(
                        AppError.Unauthorized
                    )
                }

                else -> {
                    ApiResult.Error(
                        AppError.BackendError(
                            message = "Request failed",
                            code = e.response.status.value
                        )
                    )
                }
            }

        } catch (_: ServerResponseException) {

            ApiResult.Error(
                AppError.ServerError
            )

        } catch (_: Exception) {

            ApiResult.Error(
                AppError.Unknown
            )
        }
    }

}