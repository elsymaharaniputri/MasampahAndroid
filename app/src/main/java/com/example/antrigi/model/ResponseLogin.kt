package com.example.antrigi.model
import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @field:SerializedName("data")
    val data: DataLogin? = null,
    @field:SerializedName("success")
    val success: Boolean? = null,
    @field:SerializedName("message")
    val message: String? = null
)

data class DataLogin(

    @field:SerializedName("password")
    val password: String? = null,
    @field:SerializedName("id")
    val id: Int? = null,
    @field:SerializedName("token")
    val token: String? = null
)
