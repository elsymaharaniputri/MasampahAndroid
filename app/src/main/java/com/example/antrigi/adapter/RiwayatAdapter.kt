package com.example.antrigi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.antrigi.R
import com.example.antrigi.model.DataItem2

class RiwayatAdapter (dataRiwayat:List<DataItem2?>?): RecyclerView.Adapter<RiwayatAdapter.MyViewHolder2>(){
    val dataRiwayat = dataRiwayat
    class MyViewHolder2 (view: View):RecyclerView.ViewHolder(view){
        val tanggal_jemput = view.findViewById<TextView>(R.id.tanggal_jemput)
        val poin = view.findViewById<TextView>(R.id.poin)
        val alamat_jemput = view.findViewById<TextView>(R.id.alamat_jemput)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_riwayat, parent, false)
        return MyViewHolder2(view)
    }
    override fun getItemCount(): Int {
        if (dataRiwayat != null){
            return dataRiwayat.size
        }
        return 0
    }
    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
        holder.tanggal_jemput.text = dataRiwayat?.get(position)?.tanggalJemput
        holder.poin.text = dataRiwayat?.get(position)?.poin
        holder.alamat_jemput.text = dataRiwayat?.get(position)?.alamatJemput

        holder.itemView.setOnClickListener{
            val tanggal_jemput = dataRiwayat?.get(position)?.tanggalJemput
            Toast.makeText(holder.itemView.context, "${tanggal_jemput}", Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener{
            val poin = dataRiwayat?.get(position)?.poin
            Toast.makeText(holder.itemView.context, "${poin}", Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener{
            val alamat_jemput = dataRiwayat?.get(position)?.poin
            Toast.makeText(holder.itemView.context, "Alamat Jemput : ${alamat_jemput}", Toast.LENGTH_SHORT).show()
        }
    }


}