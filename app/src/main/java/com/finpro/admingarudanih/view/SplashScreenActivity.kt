package com.finpro.admingarudanih.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.view.auth.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
        },3000)
    }
}