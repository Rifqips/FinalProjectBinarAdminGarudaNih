package com.finpro.admingarudanih.model.tickets


import com.google.gson.annotations.SerializedName

data class ResponseAddTiket(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("status")
    val status: String
)