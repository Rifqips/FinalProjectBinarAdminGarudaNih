package com.finpro.admingarudanih.view.updatetiket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivityUpdateTiketBinding
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import com.finpro.admingarudanih.viewmodel.TicketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateTiketActivity : AppCompatActivity() {
    lateinit var authViewModel : AuthViewModel
    private var authToken : String = ""
    lateinit var binding : ActivityUpdateTiketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateTiketBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val bundle = intent.extras
        binding.etArriveUpdate.setText(bundle!!.getString("arrive"))
        binding.etChairUpdate.setText(bundle.getInt("totalchair").toString())
        binding.etClassUpdate.setText(bundle.getString("class"))
        binding.etDepartureUpdate.setText(bundle.getString("departure"))
        binding.etTypeUpdate.setText(bundle.getString("type"))
        binding.etDepartureCodeUpdate.setText(bundle.getString("depCode"))
        binding.etDestinationCodeUpdate.setText(bundle.getString("desCode"))
        binding.etDestinationUpdate.setText(bundle.getString("destinasi"))
        binding.etJenisTiketUpdate.setText(bundle.getString("flight"))
        binding.etPriceUpdate.setText(bundle.getInt("harga").toString())
        binding.etTakeOffUpdate.setText(bundle.getString("takeOff"))

        binding.btnUpdateTiket.setOnClickListener {
            editTiket()
        }



    }
    private fun editTiket(){
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.getToken().observe(this){token->
            if (token != null){
                authToken = "Bearer "+token
            }
        }

        val bundle = intent.extras
        val id = bundle!!.getInt("idTiket").toString()

        val viewModelTiket = ViewModelProvider(this).get(TicketViewModel::class.java)

        val addArrive = binding.etArriveUpdate.text.toString()
        val addClass = binding.etClassUpdate.text.toString()
        val addDepa = binding.etDepartureUpdate.text.toString()
        val addDepaCode = binding.etDepartureCodeUpdate.text.toString()
        val addDesti = binding.etDestinationUpdate.text.toString()
        val addDestiCode = binding.etDestinationCodeUpdate.text.toString()
        val addFlight = binding.etJenisTiketUpdate.text.toString()
        val addPrice = binding.etPriceUpdate.text.toString()
        val addTO = binding.etTakeOffUpdate.text.toString()
        val addKursi = binding.etChairUpdate.text.toString()
        val addType = binding.etTypeUpdate.text.toString()

        viewModelTiket.callUpdateTiket(authToken,id.toInt(),addArrive,addClass,addDepa,addDepaCode,addDesti,addDestiCode,addFlight,addPrice.toInt(),addTO,addKursi.toInt(),addType)
        viewModelTiket.updateTiketObserve().observe(this){
            if (it != null){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Tiket Berhasil Di Edit", Toast.LENGTH_SHORT).show()
            }
        }




    }
}