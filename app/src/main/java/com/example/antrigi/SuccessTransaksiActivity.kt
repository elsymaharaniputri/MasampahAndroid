package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SuccessTransaksiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_transaksi)

        val actButton1 = findViewById<Button>(R.id.riwayat)
        actButton1.setOnClickListener {
            val Intent = Intent(this, RiwayatActivity::class.java)
            startActivity(Intent)
        }
    }
}