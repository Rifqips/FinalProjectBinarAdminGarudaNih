package com.finpro.admingarudanih.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}