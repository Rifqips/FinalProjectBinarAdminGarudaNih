package com.finpro.admingarudanih.model.admin


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("users")
    val users: Users
)