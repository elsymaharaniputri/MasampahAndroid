package com.example.antrigi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TukarFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tukar, container, false)

        val actButton1 = view.findViewById<Button>(R.id.kirim)
        actButton1.setOnClickListener {
            val intent = Intent(activity, HasilPoinActivity::class.java)
            startActivity(intent)
        }

        return view
    }




}