package com.finpro.admingarudanih.model.tickets


import com.google.gson.annotations.SerializedName

data class ResponseLocalTicket(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)