package com.example.antrigi.model

import com.google.gson.annotations.SerializedName

data class RequestTransaksi(

	@field:SerializedName("kategori_id")
	val kategoriId: String? = null,

	@field:SerializedName("berat_sampah")
	val beratSampah: Int? = null,

	@field:SerializedName("tanggal_jemput")
	val tanggalJemput: String? = null,

	@field:SerializedName("alamat_jemput")
	val alamatJemput: String? = null
)
