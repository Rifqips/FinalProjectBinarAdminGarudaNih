package com.finpro.admingarudanih.viewmodel

import androidx.lifecycle.ViewModel
import com.finpro.admingarudanih.repository.DataUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repo: DataUserRepository): ViewModel() {

    fun getUserToken(token : String) = repo.getDataUser(token)
    fun getCurrentObserve() = repo.getCurrentUserObserve()

    fun historyUser(token: String)= repo.getTransaksi(token)
    fun getHistoryObserve() = repo.getHistoryObserve()

}