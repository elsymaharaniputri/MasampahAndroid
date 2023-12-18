package com.example.antrigi.api

import com.example.antrigi.model.RequestUser
import com.example.antrigi.model.ResponseJenisSampah
import com.example.antrigi.model.ResponseRiwayat
import com.example.antrigi.model.ResponseTransaksi
import com.example.antrigi.model.ResponseUser
import com.example.antrigi.token.TokenManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("kategori")
    fun getJenis(@Header("Authorization") token: String): Call<ResponseJenisSampah>

    @GET("transaksi")
    fun getRiwayat(@Header("Authorization") token: String): Call<ResponseRiwayat>

    @FormUrlEncoded
    @POST("transaksi")
    fun postTransaksi(
        @Field("kategori_id") kategori_id:String,
        @Field("berat_sampah") berat_sampah:Int,
        @Field("alamat_jemput") alamat_jemput:String,
        @Field("tanggal_jemput") tanggal_jemput:String,
        @Header("Authorization") token: String
    ): Call<ResponseBody>

    @GET("transaksi")
    fun getTransaksi(@Header("Authorization") token: String): Call<ResponseTransaksi>
    @FormUrlEncoded
    @POST("user")
    fun register(
        @Field("username") username:String,
        @Field("password") password:String,
        @Field("alamat") alamat:String,
        @Field("hp") hp:String,

    ):Call<ResponseBody>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username:String,
        @Field("password") password:String,
        ):Call<ResponseBody>

}