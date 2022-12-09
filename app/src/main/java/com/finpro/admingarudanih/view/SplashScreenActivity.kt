package com.finpro.admingarudanih.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivitySplashScreenBinding
import com.finpro.admingarudanih.utils.CheckUserUtil
import com.finpro.admingarudanih.view.auth.LoginActivity
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.AuthViewModel

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding
    lateinit var authViewModel : AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
//            sudahlogin()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
        },3000)
    }
    private fun sudahlogin(){
        authViewModel.getToken().observe(this){
            if (it != null){
                val validasi = CheckUserUtil.validateUser(it)
                if (validasi){
                    startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }

        authViewModel.getNoHp().observe(this){
            if (it != null){
                if (!it.equals("undefined")){
                    startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }

    }
}