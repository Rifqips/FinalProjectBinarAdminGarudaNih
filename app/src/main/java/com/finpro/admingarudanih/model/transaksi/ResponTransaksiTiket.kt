package com.finpro.admingarudanih.model.transaksi


import com.google.gson.annotations.SerializedName

data class ResponTransaksiTiket(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)