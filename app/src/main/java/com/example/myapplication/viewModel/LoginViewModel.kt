package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Users

class LoginViewModel : ViewModel() {

    val usermutalbeLiveData = MutableLiveData("Login successful")


    fun login_fun(){
//        println("This is ViewModel")
        usermutalbeLiveData.value = "Success"
    }
}