package com.finpro.admingarudanih.view.addnewtiket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivityTambahTiketBinding
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import com.finpro.admingarudanih.viewmodel.TicketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TambahTiketActivity : AppCompatActivity() {
    lateinit var binding : ActivityTambahTiketBinding
    lateinit var authViewModel : AuthViewModel
    private var authToken : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahTiketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        authViewModel.getToken().observe(this){token->
            if (token != null){
                authToken = "Bearer "+token
            }
        }

        binding.btnTambahTiket.setOnClickListener {
            val addArrive = binding.etArrive.text.toString()
            val addClass = binding.etClass.text.toString()
            val addDepa = binding.etDeparture.text.toString()
            val addDepaCode = binding.etDepartureCode.text.toString()
            val addDesti = binding.etDestination.text.toString()
            val addDestiCode = binding.etDestinationCode.text.toString()
            val addFlight = binding.etJenisTiket.text.toString()
            val addPrice = binding.etPrice.text.toString()
            val addTO = binding.etTakeOff.text.toString()
            val addKursi = binding.etChair.text.toString()
            val addType = binding.etType.text.toString()

            addTiket(authToken, addArrive,addClass,addDepa,addDepaCode,addDesti,addDestiCode,addFlight,addPrice.toInt(),addTO,addKursi.toInt(),addType)
            Toast.makeText(this,"add data sukses", Toast.LENGTH_SHORT).show()
        }



    }
    fun addTiket(token : String,
                 arrive:String,
                 classX:String,
                 departure:String,
                 departureCode:String,
                 destination:String,
                 destinationCode:String,
                 flight:String,
                 price: Int,
                 takeOff:String,
                 totalChair:Int,
                 type:String){
        val viewModelTiket = ViewModelProvider(this).get(TicketViewModel::class.java)
        viewModelTiket.callAddTiket(token,arrive,classX, departure, departureCode, destination, destinationCode, flight, price, takeOff, totalChair, type)
        viewModelTiket.postNewTiket().observe(this){
            if (it != null){
                Toast.makeText(this,"add data sukses", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
        finish()
    }
}