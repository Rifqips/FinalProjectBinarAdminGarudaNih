package com.finpro.admingarudanih.model.getusers

import com.google.gson.annotations.SerializedName

data class GetUserItem(
    @SerializedName("data")
    val `data`: List<DataUserItem>,
    @SerializedName("status")
    val status: String
)