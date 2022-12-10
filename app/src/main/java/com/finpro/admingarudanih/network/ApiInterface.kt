package com.finpro.admingarudanih.network

import com.finpro.admingarudanih.model.auth.ResponseUserLogin
import com.finpro.admingarudanih.model.auth.UserLogin
import com.finpro.admingarudanih.model.getusers.DataUserItem
import com.finpro.admingarudanih.model.getusers.GetUserItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("v1/user/login")
    fun loginUser(@Body userLogin : UserLogin): Call<ResponseUserLogin>

    @GET("v1/admin/all")
    fun getUser(@Header("Authorization")authHeader : String): Call<GetUserItem>
}