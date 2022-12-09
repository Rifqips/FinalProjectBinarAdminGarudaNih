package com.finpro.admingarudanih.model.auth

data class UserLogin (
    val email : String,
    val password : String
)

data class ResponseUserLogin(
    val token : String
)
// current
data class ResponseUserCurrent(
    val id : Int,
    val name : String,
    val email : String,
    val password : String,
    val image : String,
    val phone : String,
    val birth : String,
    val role : String,
    val isExist : Boolean,
    val isVerify : String,
    val deleteAt : String,
    val createdAt : String,
    val updatedAt : String
)
//update profile
data class UpdateProfile(
    val hoHp : String,
    val birth : String,
    val image : String,
)