package com.example.myapplication.eCom.data.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.eCom.Dashboard
import com.example.myapplication.eCom.data.model.login.ValidateUserRequest
import com.example.myapplication.eCom.data.remote.APIClient
import com.example.myapplication.eCom.data.remote.RetrofitClient
import com.example.myapplication.eCom.data.repository.LoginRepository
import com.example.myapplication.eCom.utils.APIResponse
import com.example.myapplication.eCom.utils.Resource
import retrofit2.Call
import retrofit2.Response

class LoginNewActivity : AppCompatActivity() {

    lateinit var apiClient: APIClient


    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_new)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getInstance()
        callAPI()
    }

    fun getInstance(){

        apiClient = RetrofitClient.getInstance().create(APIClient::class.java)
        val repository = LoginRepository(apiClient)
        val viewModelFactory = LoginViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]

        viewModel.loginResult.observe(this) {
            when(it){
                is Resource.Error -> Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                is Resource.Loading -> { }
                is Resource.Success ->{
                    Toast.makeText(this, "Success: ${it.data?.message}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Dashboard::class.java)
                    startActivity(intent)
                    this.finish()
                }
            }
        }

    }

    fun callAPI(){
        val etusername = findViewById<EditText>(R.id.et_username)
        val etpassword = findViewById<EditText>(R.id.et_password)
        findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            viewModel.validateUser(etusername.text.toString(),etpassword.text.toString())
        }
//  THis code is call the API without implementation mvvm arch
//            val validateUserRequest= ValidateUserRequest(etusername.text.toString(),etpassword.text.toString())


//            val call  =  apiClient?.validateUser(validateUserRequest)

//            val call  = apiClient?.validateUser(validateUserRequest)
//            println("call${call.toString()}")
//            call?.(object :retrofit2.Callback<APIResponse>{
//                override fun onResponse(
//                    call: Call<APIResponse?>,
//                    response: Response<APIResponse?>
//                ) {
//                    if (response.isSuccessful){
//                        val body = response.body()
//                        Log.d("LOGINRESPONSE", (body ?: "Empty response").toString())
//                    }else {
//                        Log.e("LOGINRESPONSE", "Failed with code ${response.code()}")
//                    }
//
//
//                }
//
//                override fun onFailure(
//                    call: Call<APIResponse?>,
//                    t: Throwable
//                ) {
//                    t.printStackTrace()
//                }
//
//
//            })


    }
}