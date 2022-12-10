package com.finpro.admingarudanih.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.finpro.admingarudanih.databinding.ActivitySplashScreenBinding
import com.finpro.admingarudanih.utils.CheckUserUtil
import com.finpro.admingarudanih.view.auth.LoginActivity
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding
    private lateinit var authViewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        Handler().postDelayed({
            sudahlogin()
            finish()
        },3000)
        setContentView(binding.root)
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