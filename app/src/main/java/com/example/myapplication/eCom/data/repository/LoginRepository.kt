package com.example.myapplication.eCom.data.repository

import com.example.myapplication.eCom.data.model.login.ValidateUserRequest
import com.example.myapplication.eCom.data.remote.APIClient
import com.example.myapplication.eCom.utils.APIResponse
import retrofit2.Response

class LoginRepository(val apiClient: APIClient) {
    suspend fun valdateUser(validateUserRequest: ValidateUserRequest):  Response<APIResponse>{
        return apiClient.validateUser(validateUserRequest)
    }
}