package com.finpro.admingarudanih.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.finpro.admingarudanih.model.tickets.RequestBodyTiket
import com.finpro.admingarudanih.model.tickets.ResponseAddTiket
import com.finpro.admingarudanih.model.tickets.ResponseLocalTicket
import com.finpro.admingarudanih.model.tickets.ResponseUpdate
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
    lateinit var addNewTiket : MutableLiveData<ResponseAddTiket?>
    lateinit var deleteDataTiket : MutableLiveData<ResponseLocalTicket?>
    lateinit var updateDataTiket : MutableLiveData<ResponseUpdate?>


    init {
        ldListTiketLokal = MutableLiveData()
        ldListTicketIntr = MutableLiveData()
        addNewTiket = MutableLiveData()
        deleteDataTiket = MutableLiveData()
        updateDataTiket = MutableLiveData()
    }


    fun getLdTiketLocal():MutableLiveData<ResponseLocalTicket?>{
        return ldListTiketLokal
    }
    fun getLdTiketIntr(): MutableLiveData<ResponseLocalTicket?>{
        return ldListTicketIntr
    }
    fun postNewTiket():MutableLiveData<ResponseAddTiket?>{
        return addNewTiket
    }
    fun deleteTiketObserve(): MutableLiveData<ResponseLocalTicket?>{
        return deleteDataTiket
    }
    fun updateTiketObserve():MutableLiveData<ResponseUpdate?>{
        return updateDataTiket
    }

    fun callUpdateTiket(token : String,
                        id: Int,
                        arrive:String,
                        classX:String,
                        departure:String,
                        departureCode:String,
                        destination:String,
                        destinationCode:String,
                        flight:String,
                        price: Int,
                        takeOff:String,
                        totalChair:Int,
                        type:String){
        api.editTiket(token,id,
            RequestBodyTiket(arrive,classX, departure, departureCode, destination, destinationCode, flight, price, takeOff, totalChair, type))
            .enqueue(object : Callback<ResponseUpdate>{
                override fun onResponse(
                    call: Call<ResponseUpdate>,
                    response: Response<ResponseUpdate>
                ) {
                    if (response.isSuccessful){
                        updateDataTiket.postValue(response.body())
                        Log.d("update",response.body()?.message.toString())
                    }else{
                        updateDataTiket.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseUpdate>, t: Throwable) {
                    updateDataTiket.postValue(null)
                    
                }

            })

    }

    fun callDeleteTiket(id : Int){
        api.deleteTiket(id)
            .enqueue(object : Callback<ResponseLocalTicket>{
                override fun onResponse(
                    call: Call<ResponseLocalTicket>,
                    response: Response<ResponseLocalTicket>
                ) {
                    if (response.isSuccessful){
                        deleteDataTiket.postValue(response.body())
                        Log.d("delete",response.body()?.data.toString())
                    }else{
                        deleteDataTiket.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseLocalTicket>, t: Throwable) {
                    deleteDataTiket.postValue(null)
                }

            })
    }

    fun callAddTiket(token : String,
                     arrive:String,
                     classX:String,
                     departure:String,
                     departureCode:String,
                     destination:String,
                     destinationCode:String,
                     flight:String,
                     price: Int,
                     takeOff:String,
                     totalChair:Int,
                     type:String){
        api.postTiket(token, RequestBodyTiket(arrive,classX,departure,departureCode,destination,destinationCode,flight,price,takeOff,totalChair,type))
            .enqueue(object :Callback<ResponseAddTiket>{
                override fun onResponse(
                    call: Call<ResponseAddTiket>,
                    response: Response<ResponseAddTiket>
                ) {
                    if (response.isSuccessful){
                        addNewTiket.postValue(response.body())
                        Log.d("add",response.body()?.data.toString())
                    }else{
                        addNewTiket.postValue(null)
                        Log.d("add",response.body()?.data.toString())
                    }
                }

                override fun onFailure(call: Call<ResponseAddTiket>, t: Throwable) {
                    addNewTiket.postValue(null)
                }

            })

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