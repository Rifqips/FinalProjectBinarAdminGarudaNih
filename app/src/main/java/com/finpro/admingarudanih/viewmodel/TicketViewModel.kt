package com.finpro.admingarudanih.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finpro.admingarudanih.model.tickets.ResponseLocalTicket
import com.finpro.admingarudanih.network.ApiInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TicketViewModel @Inject constructor(var api : ApiInterface): ViewModel() {
    lateinit var ldListTiketLokal : MutableLiveData<ResponseLocalTicket?>
    lateinit var ldListTicketIntr : MutableLiveData<ResponseLocalTicket?>


    init {
        ldListTiketLokal = MutableLiveData()
        ldListTicketIntr = MutableLiveData()
    }

    fun getLdTiketLocal():MutableLiveData<ResponseLocalTicket?>{
        return ldListTiketLokal
    }
    fun getLdTiketIntr(): MutableLiveData<ResponseLocalTicket?>{
        return ldListTicketIntr
    }

    fun callTicketIntr(){
        api.getIntrTicket()
            .enqueue(object : Callback<ResponseLocalTicket>{
                override fun onResponse(
                    call: Call<ResponseLocalTicket>,
                    response: Response<ResponseLocalTicket>
                ) {
                    if (response.isSuccessful){
                        ldListTicketIntr.postValue(response.body())
                        Log.d("data",response.body()?.data.toString())
                    }else{
                        Log.d("data",response.body()?.data.toString())
                    }

                }

                override fun onFailure(call: Call<ResponseLocalTicket>, t: Throwable) {
                    ldListTicketIntr.postValue(null)
                }

            })
    }

    fun callTicketLocal(){
        api.getLocalTicket()
            .enqueue(object  : Callback<ResponseLocalTicket>{
                override fun onResponse(
                    call: Call<ResponseLocalTicket>,
                    response: Response<ResponseLocalTicket>
                ) {
                    if (response.isSuccessful){
                        ldListTiketLokal.postValue(response.body())
                        Log.d("data",response.body()?.data.toString())
                    }else{
                        Log.d("data",response.body()?.data.toString())
                    }
                }

                override fun onFailure(call: Call<ResponseLocalTicket>, t: Throwable) {
                    ldListTiketLokal.postValue(null)
                }

            })
    }
}