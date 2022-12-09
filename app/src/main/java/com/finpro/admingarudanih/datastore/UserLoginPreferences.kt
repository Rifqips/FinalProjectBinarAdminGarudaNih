package com.finpro.admingarudanih.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.finpro.admingarudanih.utils.Constan
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.userLoginAuth : DataStore<Preferences> by preferencesDataStore(name = Constan.DS_NAME)
class UserLoginPreferences(@ApplicationContext private val context : Context){

    private val tokenKey = stringPreferencesKey(Constan.TOKEN_KEY)

    suspend fun setToken(token : String){
        context.userLoginAuth.edit {
            it[tokenKey] = token
        }
    }
    fun  getToken(): Flow<String> {
        return context.userLoginAuth.data.map {
            it[tokenKey] ?: "undefined"
        }
    }
    suspend fun deleteToken(){
        context.userLoginAuth.edit {
            it.clear()
        }
    }

}