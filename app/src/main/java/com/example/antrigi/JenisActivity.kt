package com.example.antrigi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.antrigi.adapter.JenisAdapter
import com.example.antrigi.api.ApiConfig
import com.example.antrigi.api.ApiService
import com.example.antrigi.model.ResponseJenisSampah
import com.example.antrigi.token.TokenManager
import retrofit2.Call
import retrofit2.Response

class JenisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jenis)
        val jenis = findViewById<RecyclerView>(R.id.jenisRecycler)
        val actButton = findViewById<Button>(R.id.back)

        actButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
            ApiConfig.getService().getJenis("Bearer ${TokenManager.getToken(this)}")
                .enqueue(object : retrofit2.Callback<ResponseJenisSampah> {
                    override fun onResponse(
                        call: Call<ResponseJenisSampah>,
                        response: Response<ResponseJenisSampah>
                    ) {
                        if (response.isSuccessful) {
                            val responseJenis = response.body()
                            val dataJenis = responseJenis?.data
                            val jenisAdapter = JenisAdapter(dataJenis)
                            jenis.apply {
                                layoutManager = GridLayoutManager(this@JenisActivity, 2)
                                setHasFixedSize(true)
                                jenisAdapter.notifyDataSetChanged()
                                adapter = jenisAdapter
                            }

                            Toast.makeText(this@JenisActivity, "Halaman Kategori", Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onFailure(call: Call<ResponseJenisSampah>, t: Throwable) {
                        Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT)
                            .show()
                    }
                })
        }
    }


