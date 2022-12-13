package com.finpro.admingarudanih.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finpro.admingarudanih.databinding.ActivityUpdateUserBinding
import com.finpro.admingarudanih.view.home.HomeActivity

class UpdateUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}