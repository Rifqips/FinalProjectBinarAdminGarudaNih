package com.finpro.admingarudanih.model.getusers


import com.google.gson.annotations.SerializedName

data class DataUserItem(
    @SerializedName("birth")
    val birth: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("isExist")
    val isExist: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: Int,
    @SerializedName("role")
    val role: String,
    @SerializedName("updateAt")
    val updateAt: String
)