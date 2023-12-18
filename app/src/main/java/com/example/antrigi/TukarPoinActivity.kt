package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.antrigi.api.ApiConfig
import com.example.antrigi.databinding.ActivityRegisterBinding
import com.example.antrigi.databinding.ActivityTukarPoinBinding
import com.example.antrigi.token.TokenManager
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TukarPoinActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTukarPoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTukarPoinBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        val actButton2 = findViewById<Button>(R.id.back)
        actButton2.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        mBinding.tukar.setOnClickListener{
            transaksi()
        }

    }

    fun transaksi(){
        if(mBinding.inputKategori.text.isEmpty()){
            mBinding.inputKategori.error = "Isi kolom kategori"
            mBinding.inputKategori.requestFocus()
            return
        }
        else if(mBinding.inputBerat.text.isEmpty()){
            mBinding.inputBerat.error = "Isi kolom berat"
            mBinding.inputBerat.requestFocus()
            return
        }
        else if(mBinding.inputAlamat.text.isEmpty()){
            mBinding.inputAlamat.error = "Isi kolom alamat"
            mBinding.inputAlamat.requestFocus()
            return
        }
        else if(mBinding.tanggal.text.isEmpty()){
            mBinding.tanggal.error = "Isi tanggal jemput"
            mBinding.tanggal.requestFocus()
            return
        }

        ApiConfig.getService().postTransaksi(
            mBinding.inputKategori.text.toString(),
            mBinding.inputBerat.text.toString().toInt(),
            mBinding.inputAlamat.text.toString(),
            mBinding.inputTanggal.text.toString(),
            "Bearer ${TokenManager.getToken(this)}"
        ).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                try {
                    if (response.isSuccessful) {
                        // Handle successful response
                        Toast.makeText(this@TukarPoinActivity, "Transaksi Berhasil,Lihat Di Riwayat", Toast.LENGTH_SHORT).show()
                        val transactionData = response.body()?.string()

                        // Setelah berpindah ke DetailActivity, pindah ke halaman Riwayat
                        val riwayatIntent = Intent(this@TukarPoinActivity, RiwayatActivity::class.java)
                        startActivity(riwayatIntent)

                        // Jika Anda ingin menutup halaman saat pindah ke halaman Riwayat, gunakan finish()
                        finish()


                    }
                }catch (e: Exception) {
                    // Handle exceptions (e.g., parsing errors, etc.)
                    e.printStackTrace()
                    Toast.makeText(this@TukarPoinActivity, "Terjadi kesalahan: ${e.message}", Toast.LENGTH_SHORT).show()
                }


        }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@TukarPoinActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}