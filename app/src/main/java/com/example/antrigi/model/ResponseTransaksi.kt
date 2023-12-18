package com.example.antrigi.model

import com.google.gson.annotations.SerializedName

data class ResponseTransaksi(

	@field:SerializedName("data")
	val data: Data5? = null
)

data class Data5(

	@field:SerializedName("poin")
	val poin: Int? = null,

	@field:SerializedName("kategori_id")
	val kategoriId: Int? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("total_berat")
	val totalBerat: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("berat_sampah")
	val beratSampah: Int? = null,

	@field:SerializedName("tanggal_jemput")
	val tanggalJemput: String? = null,

	@field:SerializedName("alamat_jemput")
	val alamatJemput: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)
