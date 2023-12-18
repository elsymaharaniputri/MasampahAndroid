package com.example.antrigi.model

import com.google.gson.annotations.SerializedName

data class ResponseJenisSampah(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("kategori_sampah")
	val kategoriSampah: String? = null,

	@field:SerializedName("harga_sampah")
	val hargaSampah: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)
