package com.example.myapplication.allDummyFolder

import android.util.Log
import javax.inject.Inject

interface  UserRepository {
    fun save(email: String, password: String)
}

class SQLRepository @Inject constructor(): UserRepository{

    override fun save(email: String, password: String){
        Log.d("Insert", "User saved in db")
    }
}

class FireBaseRepository: UserRepository{
    override fun save(email: String, password: String) {
        Log.d("Insert","Firebase data save")
    }

}