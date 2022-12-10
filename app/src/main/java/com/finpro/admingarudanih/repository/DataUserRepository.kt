package com.finpro.admingarudanih.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.finpro.admingarudanih.model.getusers.DataUserItem
import com.finpro.admingarudanih.model.getusers.GetUserItem
import com.finpro.admingarudanih.model.getusers.ResponseAllUsers
import com.finpro.admingarudanih.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DataUserRepository @Inject constructor(private val api: ApiInterface) {

    private val getCurrentUser : MutableLiveData<ResponseAllUsers?> = MutableLiveData()

    fun getCurrentUserObserve(): MutableLiveData<ResponseAllUsers?> = getCurrentUser

    fun getDataUser(token:String){
        api.getUser(token)
            .enqueue(object : Callback<ResponseAllUsers> {
                override fun onResponse(
                    call: Call<ResponseAllUsers>,
                    response: Response<ResponseAllUsers>
                ) {
                    if (response.isSuccessful){
                        val body = response.body()
                        if (body != null){
                            getCurrentUser.postValue(body)
                        }else{
                            getCurrentUser.postValue(null)
                            Log.d("CURRENT_USER","Null")
                        }
                    }else{
                        getCurrentUser.postValue(null)
                        Log.d("CURRENT_USER",response.message())
                    }
                }

                override fun onFailure(call: Call<ResponseAllUsers>, t: Throwable) {
                    getCurrentUser.postValue(null)
                    Log.d("CURRENT_USER","onFailure")
                }

            })
    }

}