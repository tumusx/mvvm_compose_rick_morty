package com.github.tumusx.rickmortyapi.common

sealed class ResultResource<T>(val message: String? = null, val dataResult: T? = null) {
    class Success<T>(dataResult: T) : ResultResource<T>(dataResult = dataResult)
    class Error<T>(message: String? = null, dataResult: T? = null) : ResultResource<T>(message, dataResult)

    class Loading<T>(dataResult: T? = null) : ResultResource<T>(dataResult = dataResult)
}