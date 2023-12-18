package com.example.antrigi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val actButton = findViewById<Button>(R.id.buttonJenis)
        val actButton2 = findViewById<Button>(R.id.buttonTukar)
        val actButton3 = findViewById<Button>(R.id.buttonRiwayat)

        actButton.setOnClickListener {
            val intent = Intent(this, JenisActivity::class.java)
            startActivity(intent)
        }
        actButton2.setOnClickListener {
            val intent = Intent(this, TukarPoinActivity::class.java)
            startActivity(intent)
        }
        actButton3.setOnClickListener {
            val intent = Intent(this, RiwayatActivity::class.java)
            startActivity(intent)
        }


    }



}