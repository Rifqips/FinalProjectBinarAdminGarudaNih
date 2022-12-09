package com.finpro.admingarudanih.utils

object LoginUtil {
    fun validateUserlogin( email: String, password: String): String {

        var result = ""
        if (email.isEmpty()){
            result =  "please enter username"
        } else {
            result =  "success"
        }

        if(password.isEmpty()){
            result =  "please enter password"
        }  else {
            result =  "success"
        }

        return result


    }
}