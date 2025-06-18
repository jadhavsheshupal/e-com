package com.example.myapplication.eCom.data.remote

import com.example.myapplication.eCom.data.model.AddUserRequest
import com.example.myapplication.eCom.data.model.login.ValidateUserRequest
import com.example.myapplication.eCom.utils.APIResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIClient {

    @POST("/addUser")
    fun addUser(@Body addUserRequest: AddUserRequest): String

    @POST("/validateuser")
    suspend fun validateUser(@Body validateUserRequest: ValidateUserRequest): Response<APIResponse>
}