package com.example.myapplication.eCom.data.model.login

import com.google.gson.annotations.SerializedName

data class ValidateUserRequest(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("password")
	val password: String? = null
)