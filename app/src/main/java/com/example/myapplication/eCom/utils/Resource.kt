package com.example.myapplication.eCom.utils

sealed class Resource<T> (
    val data: T? = null,
    val message: String? = null
){
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String) : Resource<T>(null, message)
}