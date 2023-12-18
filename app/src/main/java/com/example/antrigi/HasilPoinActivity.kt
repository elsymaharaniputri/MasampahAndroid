package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HasilPoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_poin)

        val actButton1 = findViewById<Button>(R.id.kirim2)
        actButton1.setOnClickListener {
            val Intent= Intent(this,SuccessTransaksiActivity::class.java)
            startActivity(Intent)
        }
    }
}