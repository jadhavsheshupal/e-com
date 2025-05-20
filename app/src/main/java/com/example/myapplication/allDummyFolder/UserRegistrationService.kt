package com.example.myapplication.allDummyFolder

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val  notificationServices: NotificationServices
){

    fun registerUser(email:String, password:String){
        userRepository.save(email,password)
        notificationServices.send("no-replay@gmail.com", "abc@gmail.com","User registration")
    }
}