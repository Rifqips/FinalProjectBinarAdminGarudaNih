package com.finpro.admingarudanih.model.getusers


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("user")
    val user: List<User>
)