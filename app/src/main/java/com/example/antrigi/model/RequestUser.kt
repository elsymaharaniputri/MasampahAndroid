package com.example.antrigi.model

import com.google.gson.annotations.SerializedName

data class RequestUser(

	@field:SerializedName("password")
	var password: String? = null,

	@field:SerializedName("hp")
	var hp: String? = null,

	@field:SerializedName("username")
	var username: String? = null,

	@field:SerializedName("alamat")
	var alamat: String? = null
)
