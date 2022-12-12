package com.finpro.admingarudanih.view.detail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.finpro.admingarudanih.databinding.ActivityDetailBinding
import com.finpro.admingarudanih.view.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import de.hdodenhof.circleimageview.CircleImageView

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getUser()
        binding.ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getUser(){
        val itemUser = intent

        val id = itemUser.getIntExtra("id",0)
        val email = itemUser.getStringExtra("email")
        val username = itemUser.getStringExtra("username")
        val created = itemUser.getStringExtra("created")
        val update = itemUser.getStringExtra("update")
        val role = itemUser.getStringExtra("role")
        val phone = itemUser.getStringExtra("phone")
//        val image = itemUser.getStringExtra("image").toString().toInt()

        binding.tvIdUser.text = "ID : $id"
        binding.tvEmailUser.text = email
        binding.tvUsername.text = username
        binding.tvCreated.text = created
        binding.tvUpdated.text = update
        binding.tvRoleUser.text = role
        binding.tvPhone.text = phone
//        binding.ivSetImage.setImageResource(image)
    }
}
