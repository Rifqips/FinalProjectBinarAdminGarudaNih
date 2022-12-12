package com.finpro.admingarudanih.model.tickets


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("tickets")
    val tickets: List<Ticket>
)