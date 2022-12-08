package com.finpro.admingarudanih.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivitySplashScreenBinding
import com.finpro.admingarudanih.view.auth.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
        },3000)
    }
}