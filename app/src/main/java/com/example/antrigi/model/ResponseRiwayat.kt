package com.example.antrigi.model

import com.google.gson.annotations.SerializedName

data class ResponseRiwayat(

	@field:SerializedName("data")
	val data: List<DataItem2?>? = null
)

data class DataItem2(

	@field:SerializedName("poin")
	val poin: String? = null,

	@field:SerializedName("kategori_id")
	val kategoriId: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("total_berat")
	val totalBerat: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("berat_sampah")
	val beratSampah: String? = null,

	@field:SerializedName("tanggal_jemput")
	val tanggalJemput: String? = null,

	@field:SerializedName("alamat_jemput")
	val alamatJemput: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("status")
	val status: String? = null
)
