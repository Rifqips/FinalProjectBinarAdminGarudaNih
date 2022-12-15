package com.finpro.admingarudanih.view.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.ActivityDetailTiketBinding
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.TicketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTiketActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailTiketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTiketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackDetail.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        getListPesawat()
        binding.btnHapus.setOnClickListener {
            hapusTiket()
            Toast.makeText(this, "Tiket Berhasil Dihapus", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
    fun getListPesawat(){
        val itemListPesawat = intent
        val kota = itemListPesawat.getStringExtra("destinasi")
        val keberangkatan = itemListPesawat.getStringExtra("departure")
        val jadwal = itemListPesawat.getStringExtra("jadwal")
        val harga = itemListPesawat.getIntExtra("harga",0)
        val chair = itemListPesawat.getIntExtra("totalchair",0)
        val status = itemListPesawat.getStringExtra("class")
//        val image = itemListPesawat.getIntExtra("image",0)

        binding.txtInputAsal.text = keberangkatan
        binding.txtInputTujuan.text = kota
        binding.txtHargaDetail.text = "Harga Tiket \nRp"+harga.toString()
        binding.txtJadwal.text = "Jadwal : \n"+jadwal
        binding.txtChair.text =  "Available "+chair.toString()
        binding.txtClass.text = status+" Class"
//        binding.ivKota.setImageResource(image)

    }
    fun hapusTiket(){
        val idTiket = intent.getIntExtra("id",0)
        val viewModelTiket = ViewModelProvider(this).get(TicketViewModel::class.java)
        viewModelTiket.callDeleteTiket(idTiket)
        viewModelTiket.deleteTiketObserve().observe(this){
            if (it != null){
                Toast.makeText(this, "Tiket Berhasil Dihapus", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomeActivity::class.java))
            }
        }
    }
}