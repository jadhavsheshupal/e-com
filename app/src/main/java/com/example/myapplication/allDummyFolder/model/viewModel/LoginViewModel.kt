package com.example.myapplication.allDummyFolder.model.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val usermutalbeLiveData = MutableLiveData("Login successful")


    fun login_fun(){
//        println("This is ViewModel")
        usermutalbeLiveData.value = "Success"
    }
}