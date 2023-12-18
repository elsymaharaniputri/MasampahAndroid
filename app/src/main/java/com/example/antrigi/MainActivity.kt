package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actButton = findViewById<Button>(R.id.buttonRegister)

        actButton.setOnClickListener {
            val Intent=Intent(this,RegisterActivity::class.java)
            startActivity(Intent)
        }

        val actButton2 = findViewById<Button>(R.id.buttonLogin)

        actButton2.setOnClickListener {
            val Intent=Intent(this,LoginActivity::class.java)
            startActivity(Intent)
        }
    }
}