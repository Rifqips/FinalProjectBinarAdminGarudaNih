package com.finpro.admingarudanih.model.transaksi


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("transaction")
    val transaction: List<Transaction>
)