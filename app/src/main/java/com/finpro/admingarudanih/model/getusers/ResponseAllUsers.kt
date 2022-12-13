package com.finpro.admingarudanih.model.getusers


import com.google.gson.annotations.SerializedName

data class ResponseAllUsers(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)