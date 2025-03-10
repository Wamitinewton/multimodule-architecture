package com.newton.common.utils

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(val isLoading: Boolean = true) : NetworkResult<T>(null)
    class Success<T>(data: T?) : NetworkResult<T>(data)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)
}