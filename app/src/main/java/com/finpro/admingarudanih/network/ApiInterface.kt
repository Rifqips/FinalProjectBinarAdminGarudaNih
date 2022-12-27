package com.finpro.admingarudanih.network

import com.finpro.admingarudanih.model.admin.DataAdmin
import com.finpro.admingarudanih.model.admin.ResponAdmin
import com.finpro.admingarudanih.model.auth.ResponseUserLogin
import com.finpro.admingarudanih.model.auth.UserLogin
import com.finpro.admingarudanih.model.getusers.ResponseAllUsers
import com.finpro.admingarudanih.model.tickets.*
import com.finpro.admingarudanih.model.transaksi.ResponTransaksiTiket
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

    @PUT("v1/ticket/{id}")
    fun editTiket(@Header("Authorization")authHeader : String,
                  @Path("id")id : Int,
                  @Body request:RequestBodyTiket): Call<ResponseUpdate>

    @GET("/v1/trans")
    fun getTransaksi(@Header("Authorization")authHeader : String) : Call<ResponTransaksiTiket>

    @POST("v1/admin/register")
    fun postResgiterAdmin(@Header("Authorization")authHeader : String, @Body request: DataAdmin) : Call<ResponAdmin>

}