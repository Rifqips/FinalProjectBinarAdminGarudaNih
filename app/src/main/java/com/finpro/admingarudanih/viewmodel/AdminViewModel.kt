package com.finpro.admingarudanih.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finpro.admingarudanih.model.admin.DataAdmin
import com.finpro.admingarudanih.model.admin.ResponAdmin
import com.finpro.admingarudanih.network.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AdminViewModel  @Inject constructor(private val api : ApiInterface): ViewModel(){

    lateinit var postAdmin : MutableLiveData<ResponAdmin?>
    init {
        postAdmin = MutableLiveData()
    }

    fun postLiveDataAdmin(): MutableLiveData<ResponAdmin?> {
        return postAdmin
    }
    fun postDataAdmin(token : String, name : String, email : String, password : String){
        api.postResgiterAdmin(token, DataAdmin(name,email,password))
            .enqueue(object : Callback<ResponAdmin>{
                override fun onResponse(call: Call<ResponAdmin>, response: Response<ResponAdmin>) {
                    if (response.isSuccessful){
                        postAdmin.postValue(response.body())
                    }else{
                        Log.d("Error", response.message())
                        postAdmin.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponAdmin>, t: Throwable) {
                    postAdmin.postValue(null)
                }

            })
    }

}