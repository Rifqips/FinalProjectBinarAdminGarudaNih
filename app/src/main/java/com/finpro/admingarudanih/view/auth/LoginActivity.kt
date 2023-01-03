package com.finpro.admingarudanih.view.auth

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivityLoginBinding
import com.finpro.admingarudanih.datastore.DataStoreLogin
import com.finpro.admingarudanih.utils.LoginUtil
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var dataLogin : DataStoreLogin
    private lateinit var username : String
    private lateinit var password : String
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        dataLogin = DataStoreLogin(this)

        dataLogin.userName.asLiveData().observe(this,{
            username = it.toString()
        })

        dataLogin.userPw.asLiveData().observe(this,{
            password = it.toString()
        })

//        binding.btnRegister.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//        }
        binding.btnRegister.isGone = true

        binding.btnLogin.setOnClickListener {
//            startActivity(Intent(this, HomeBottomActivity::class.java))
            login()
        }
    }

    private fun login(){
        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val validasi = LoginUtil.validateUserlogin(email,password)
            if (validasi == "success"){
                authViewModel.doLogin(email,password)
                authViewModel.ldSigIn().observe(this){
                    if (it != null){
                        authViewModel.setToken(it.token)
                        Toast.makeText(this,"Login Sukses", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,HomeActivity::class.java))
                    }else{
                        Toast.makeText(this,"Login Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
    override fun onBackPressed() {

        AlertDialog.Builder(this)
            .setTitle("Tutup Aplikasi")
            .setMessage("Yakin tutup dari aplikasi?")
            .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                Intent(Intent.ACTION_MAIN).apply {
                    addCategory(Intent.CATEGORY_HOME)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(this)
                }
            }
            .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            .show()
    }
}