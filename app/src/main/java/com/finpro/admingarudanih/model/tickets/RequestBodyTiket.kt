package com.finpro.admingarudanih.model.tickets


import com.google.gson.annotations.SerializedName

data class RequestBodyTiket(
    @SerializedName("arrive")
    val arrive: String,
    @SerializedName("class")
    val classX: String,
    @SerializedName("departure")
    val departure: String,
    @SerializedName("departureCode")
    val departureCode: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("destinationCode")
    val destinationCode: String,
    @SerializedName("flight")
    val flight: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("takeOff")
    val takeOff: String,
    @SerializedName("totalChair")
    val totalChair: Int,
    @SerializedName("type")
    val type: String
)