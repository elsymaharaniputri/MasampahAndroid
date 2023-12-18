package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SuccesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_succes)

        val actButton = findViewById<Button>(R.id.next)

        actButton.setOnClickListener {
            val Intent= Intent(this,DashboardActivity::class.java)
            startActivity(Intent)
        }
    }
}