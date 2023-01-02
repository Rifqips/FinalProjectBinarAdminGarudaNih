package com.finpro.admingarudanih.model.admin


import com.google.gson.annotations.SerializedName

data class ResponAdmin(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)