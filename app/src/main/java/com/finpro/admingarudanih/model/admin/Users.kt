package com.finpro.admingarudanih.model.admin


import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("birth")
    val birth: Any,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("deletedAt")
    val deletedAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Any,
    @SerializedName("isExist")
    val isExist: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: Any,
    @SerializedName("role")
    val role: String,
    @SerializedName("updateAt")
    val updateAt: String
)