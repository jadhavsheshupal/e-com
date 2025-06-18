package com.example.myapplication.eCom.utils

import com.google.gson.annotations.SerializedName

data class APIResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)