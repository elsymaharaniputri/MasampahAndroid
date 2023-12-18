package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.antrigi.api.ApiConfig
import com.example.antrigi.databinding.ActivityLoginBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import com.example.antrigi.token.TokenManager
import org.json.JSONException
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.login.setOnClickListener{
            login()
        }
    }

    fun login(){
        if(mBinding.inputUsername.text.isEmpty()){
            mBinding.inputUsername.error = "Isi kolom username"
            mBinding.inputUsername.requestFocus()
            return
        }

        else if(mBinding.inputPassword.text.isEmpty()){
            mBinding.inputPassword.error = "Isi kolom password"
            mBinding.inputPassword.requestFocus()
            return
        }

        ApiConfig.getService().login(
            mBinding.inputUsername.text.toString(),
            mBinding.inputPassword.text.toString(),
        ).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val intent = Intent(this@LoginActivity, SuccesActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                if (response.isSuccessful) {
                    // Respons berhasil, dapatkan data dari response.body() jika diperlukan

                    val responseBody = response.body()?.string()

                    // Menguraikan respons JSON
                    responseBody?.let {
                        try {
                            val jsonResponse = JSONObject(it)
                            val message = jsonResponse.getString("message")
                            val bodyObject = jsonResponse.getJSONObject("body")

                            val userId = bodyObject.getInt("user_id")
                            val token = bodyObject.getString("token")
                            val username = bodyObject.getString("username")
                            val expiryDate = bodyObject.getString("expiryDate")

                            // Menampilkan data ke dalam Toast
                            val toastMessage = "Message: $message\n"
                            Toast.makeText(this@LoginActivity, toastMessage, Toast.LENGTH_LONG).show()

                            TokenManager.saveToken(this@LoginActivity, token)
                            // Lanjutkan ke halaman berikutnya setelah menyimpan token
                            val intent = Intent(this@LoginActivity, SuccesActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                            Toast.makeText(this@LoginActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()
                            // Lanjutkan dengan pengolahan data atau tindakan yang diperlukan


                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                } else {
                    // Respons gagal, dapatkan pesan kesalahan dari response.errorBody()
                    val errorBody = response.errorBody()?.string()
                    Log.d("error", errorBody ?: "Unknown error")
                    Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }



        })
    }

}