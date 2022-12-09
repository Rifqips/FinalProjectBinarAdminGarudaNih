package com.finpro.admingarudanih.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.finpro.admingarudanih.model.auth.ResponseUserLogin
import com.finpro.admingarudanih.model.auth.UserLogin
import com.finpro.admingarudanih.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val api : ApiInterface){
    val signIn : MutableLiveData<ResponseUserLogin?> = MutableLiveData()

    fun ldSignIn(): LiveData<ResponseUserLogin?> = signIn

    fun doSignIn(email : String, password : String){
        api.loginUser(UserLogin(email,password))
            .enqueue(object : Callback<ResponseUserLogin> {
                override fun onResponse(
                    call: Call<ResponseUserLogin>,
                    response: Response<ResponseUserLogin>
                ) {
                    if (response.isSuccessful){
                        val body = response.body()
                        if (body != null){
                            signIn.postValue(body)
                        }else{
                            signIn.postValue(null)
                            println("body null")
                        }
                    }else{
                        signIn.postValue(null)
                        println("Not Success -> ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ResponseUserLogin>, t: Throwable) {
                    signIn.postValue(null)
                    println("Server Error")
                }

            })
    }
}