package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Users
import com.example.myapplication.viewModel.LoginViewModel
import dagger.internal.DaggerGenerated
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

        val workManager = WorkManager.getInstance(this)
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)



        val component =  DaggerUserRegistrationComponent.builder().build()
        component.inject(this)
        userRegistrationService.registerUser("abc@gmail.com","111111")

        dowork()
        init()
    }

    private fun init(){
        val user = Users("Admin","Admin123")
        binding.users = user

        binding.userViewModel = userViewModel

        userViewModel.usermutalbeLiveData.observe(this,{
            Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()
        })
//        binding.tvSubmit.setOnClickListener {
//            println("The User name: ${binding.etUsername.text} and Password: ${binding.etPassword.text}")
//        }
    }

    private fun dowork(){
        val request = OneTimeWorkRequest.Builder(WorkManagerExample :: class.java)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build()

//        workManager.

    }
}