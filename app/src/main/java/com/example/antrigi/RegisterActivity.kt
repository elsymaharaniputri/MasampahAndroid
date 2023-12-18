package com.example.antrigi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.antrigi.api.ApiConfig
import com.example.antrigi.databinding.ActivityRegisterBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.register.setOnClickListener{
            register()
        }
    }
    fun register(){
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

        else if(mBinding.inputRegisAlamat.text.isEmpty()){
            mBinding.inputRegisAlamat.error = "Isi kolom alamat"
            mBinding.inputRegisAlamat.requestFocus()
            return
        }

        else if(mBinding.inputRegisHp.text.isEmpty()){
            mBinding.inputRegisHp.error = "Isi kolom hp"
            mBinding.inputRegisHp.requestFocus()
            return
        }

        ApiConfig.getService().register(
            mBinding.inputUsername.text.toString(),
            mBinding.inputPassword.text.toString(),
            mBinding.inputRegisAlamat.text.toString(),
            mBinding.inputRegisHp.text.toString(),
        ).enqueue(object : Callback <ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                    Toast.makeText(this@RegisterActivity, "Registrasi Berhasil! Kembali ke halaman utama untuk login" , Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }




}