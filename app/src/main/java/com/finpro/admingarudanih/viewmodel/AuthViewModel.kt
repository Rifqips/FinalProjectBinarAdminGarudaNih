package com.finpro.admingarudanih.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.finpro.admingarudanih.datastore.DataUser
import com.finpro.admingarudanih.datastore.UserLoginPreferences
import com.finpro.admingarudanih.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(@ApplicationContext context : Context, private val repository : AuthRepository):
    ViewModel() {
    private val userPreferences = UserLoginPreferences(context)
    private val dataUser = DataUser(context)

    fun setData(username : String,email: String,nohp : String, tgllahir : String, kota : String, image : String){
        viewModelScope.launch {
            dataUser.saveData(username,email,nohp,tgllahir,kota,image)
        }
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

    fun doLogin(email :String,password : String) = repository.doSignIn(email,password)
    fun ldSigIn() = repository.ldSignIn()
}