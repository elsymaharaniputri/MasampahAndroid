package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.antrigi.adapter.RiwayatAdapter
import com.example.antrigi.api.ApiConfig
import com.example.antrigi.model.ResponseRiwayat
import com.example.antrigi.token.TokenManager
import retrofit2.Call
import retrofit2.Response

class RiwayatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)
        val riwayat = findViewById<RecyclerView>(R.id.riwayatRecycler)

        val actButton = findViewById<Button>(R.id.back)
        actButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        ApiConfig.getService().getRiwayat("Bearer ${TokenManager.getToken(this)}").
        enqueue(object : retrofit2.Callback<ResponseRiwayat>{
            override fun onResponse(
                call: Call<ResponseRiwayat>,
                response: Response<ResponseRiwayat>,
            ) {
                if (response.isSuccessful){
                    val responseRiwayat = response.body()
                    val dataRiwayat = responseRiwayat?.data
                    val riwayatAdapter = RiwayatAdapter(dataRiwayat)
                    riwayat.apply {
                        layoutManager = LinearLayoutManager(this@RiwayatActivity)
                        setHasFixedSize(true)
                        riwayatAdapter.notifyDataSetChanged()
                        adapter = riwayatAdapter
                    }
                }

            }

            override fun onFailure(call: Call<ResponseRiwayat>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }
}