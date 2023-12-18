package com.example.antrigi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.antrigi.R
import com.example.antrigi.model.DataItem

class JenisAdapter(dataJenis:List<DataItem?>?): RecyclerView.Adapter<JenisAdapter.MyViewHolder>() {
    val dataJenis = dataJenis

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val kategori_sampah = view.findViewById<TextView>(R.id.kategori_sampah)
        val harga_sampah = view.findViewById<TextView>(R.id.harga_sampah)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_jenis, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataJenis != null){
            return dataJenis.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.kategori_sampah.text = dataJenis?.get(position)?.kategoriSampah
        holder.harga_sampah.text = dataJenis?.get(position)?.hargaSampah

        holder.itemView.setOnClickListener{
            val kategori_sampah = dataJenis?.get(position)?.kategoriSampah
            Toast.makeText(holder.itemView.context, "${kategori_sampah}", Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener{
            val harga_sampah = dataJenis?.get(position)?.hargaSampah
            Toast.makeText(holder.itemView.context, "${harga_sampah}", Toast.LENGTH_SHORT).show()
        }
    }

}