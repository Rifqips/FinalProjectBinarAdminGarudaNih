package com.finpro.admingarudanih.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.finpro.admingarudanih.datastore.DataUser
import com.finpro.admingarudanih.datastore.UserLoginPreferences
import com.finpro.admingarudanih.model.getusers.GetUserItem
import com.finpro.admingarudanih.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetUserViewModel @Inject constructor(@ApplicationContext context : Context, private val repository : AuthRepository):ViewModel()  {
    private val userPreferences = UserLoginPreferences(context)
    private val dataUser = DataUser(context)

    var  ldGetUset: MutableLiveData<GetUserItem?>

    init {
        ldGetUset = MutableLiveData()
    }

    fun ldGetUser(): MutableLiveData<GetUserItem?>{
        return ldGetUset
    }

    fun getUser(): LiveData<String> = dataUser.getUsername().asLiveData()
    fun getEmail(): LiveData<String> = dataUser.getEmail().asLiveData()
    fun getNoHp(): LiveData<String> = dataUser.getDataNoHp().asLiveData()
    fun getTglLahir() : LiveData<String> = dataUser.getDataTglLahir().asLiveData()
    fun getKota(): LiveData<String> = dataUser.getDataKota().asLiveData()
    fun getImage(): LiveData<String> = dataUser.getDataImage().asLiveData()

    fun setToken(token : String){
        viewModelScope.launch {
            userPreferences.setToken(token)
        }
    }

    fun deleteData(){
        viewModelScope.launch {
            dataUser.deleteDataUser()
        }
    }

    fun deleteToken(){
        viewModelScope.launch {
            userPreferences.deleteToken()
        }
    }
    fun getToken(): LiveData<String> = userPreferences.getToken().asLiveData()
}