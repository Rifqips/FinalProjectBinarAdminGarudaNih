package com.finpro.admingarudanih.network

import com.finpro.admingarudanih.model.auth.ResponseUserLogin
import com.finpro.admingarudanih.model.auth.UserLogin
import com.finpro.admingarudanih.model.getusers.DataUserItem
import com.finpro.admingarudanih.model.getusers.GetUserItem
import com.finpro.admingarudanih.model.getusers.ResponseAllUsers
import com.finpro.admingarudanih.model.tickets.DataTiket
import com.finpro.admingarudanih.model.tickets.RequestBodyTiket
import com.finpro.admingarudanih.model.tickets.ResponseAddTiket
import com.finpro.admingarudanih.model.tickets.ResponseLocalTicket
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @POST("v1/user/login")
    fun loginUser(@Body userLogin : UserLogin): Call<ResponseUserLogin>

    @GET("v1/admin/all")
    fun getUser(@Header("Authorization")authHeader : String): Call<ResponseAllUsers>

    @GET("v1/ticket-doms")
    fun getLocalTicket(): Call<ResponseLocalTicket>

    @GET("v1/ticket-intr")
    fun getIntrTicket(): Call<ResponseLocalTicket>

    @POST("v1/ticket")
    fun postTiket(@Header("Authorization")authHeader : String,
                  @Body request : RequestBodyTiket): Call<ResponseAddTiket>

    @DELETE("v1/ticket/{id}")
    fun deleteTiket(@Path("id")id : Int) : Call<ResponseLocalTicket>


}