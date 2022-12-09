package com.finpro.admingarudanih.network

import com.finpro.admingarudanih.model.auth.ResponseUserLogin
import com.finpro.admingarudanih.model.auth.UserLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("v1/user/login")
    fun loginUser(@Body userLogin : UserLogin): Call<ResponseUserLogin>
}