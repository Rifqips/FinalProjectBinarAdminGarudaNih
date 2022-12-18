package com.finpro.admingarudanih.model.transaksi


import com.google.gson.annotations.SerializedName

data class Transaction(
    @SerializedName("code")
    val code: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("date")
    val date: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isPaid")
    val isPaid: Boolean,
    @SerializedName("ktp")
    val ktp: String,
    @SerializedName("notCancelled")
    val notCancelled: Boolean,
    @SerializedName("numChair")
    val numChair: Int,
    @SerializedName("orderBy")
    val orderBy: String,
    @SerializedName("ticketCode")
    val ticketCode: String,
    @SerializedName("ticketId")
    val ticketId: Int,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
)