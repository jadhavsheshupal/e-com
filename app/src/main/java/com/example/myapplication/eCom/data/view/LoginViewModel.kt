package com.example.myapplication.eCom.data.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.eCom.data.model.login.ValidateUserRequest
import com.example.myapplication.eCom.data.repository.LoginRepository
import com.example.myapplication.eCom.utils.APIResponse
import com.example.myapplication.eCom.utils.Resource
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel() {


    private val _loginResult = MutableLiveData<Resource<APIResponse>>()
    val loginResult: LiveData<Resource<APIResponse>> = _loginResult

    fun validateUser(username:String, password:String){
        viewModelScope.launch {
            try {
                val response = loginRepository.valdateUser(ValidateUserRequest(username, password))
                if (response.isSuccessful && response.body() != null) {
                    _loginResult.postValue(Resource.Success(response.body()!!))
                } else {
                    _loginResult.postValue(Resource.Error("Login failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                _loginResult.postValue(Resource.Error("Exception: ${e.localizedMessage}"))
            }
        }
    }
}