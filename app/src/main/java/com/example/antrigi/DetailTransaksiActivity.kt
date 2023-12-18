package com.example.antrigi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import com.example.antrigi.databinding.ActivityDetailTransaksiBinding
class DetailTransaksiActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityDetailTransaksiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailTransaksiBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        // Retrieve data from Intent
        val poin = intent.getIntExtra("poin", 0)
        val beratSampah = intent.getIntExtra("berat_sampah", 0)
        val alamatJemput = intent.getStringExtra("alamat_jemput")
        val tanggalJemput = intent.getStringExtra("tanggal_jemput")

        // Update UI elements with the retrieved data
        mBinding.inputPoin.text = Editable.Factory.getInstance().newEditable("Poin: $poin")
        mBinding.inputTotalBerat.text = Editable.Factory.getInstance().newEditable("Berat Sampah: $beratSampah")
        mBinding.inputAlamatDetail.text = Editable.Factory.getInstance().newEditable("Alamat Jemput: $alamatJemput")
        mBinding.tanggalDetail.text = Editable.Factory.getInstance().newEditable("Tanggal Jemput: $tanggalJemput")
    }
}