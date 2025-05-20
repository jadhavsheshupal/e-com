package com.example.myapplication.allDummyFolder

import android.util.Log
import javax.inject.Inject

interface NotificationServices{
    fun send(to:String,from:String,body:String)
}


class EmailService @Inject constructor() : NotificationServices {

    override fun send(to:String, from:String, body:String){
        Log.d("Mail"," E-mail Send Success")
    }
}


class MessageService: NotificationServices{
    override fun send(to: String, from: String, body: String) {
        Log.d("Insert","Message send")
    }

}