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
import com.finpro.admingarudanih.view.updatetiket.UpdateTiketActivity
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
            Toast.makeText(this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show()
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
        val desCode = itemListPesawat.getStringExtra("desCode")
        val depCode = itemListPesawat.getStringExtra("depCode")
        val arrive = itemListPesawat.getStringExtra("arrive")
        val flight = itemListPesawat.getStringExtra("flight")
        val type = itemListPesawat.getStringExtra("type")
        val idTiket = itemListPesawat.getIntExtra("id",0)
//        val image = itemListPesawat.getIntExtra("image",0)

        binding.txtInputAsal.text = keberangkatan
        binding.txtInputTujuan.text = kota
        binding.txtHargaDetail.text = "Harga Tiket \nRp"+harga.toString()
        binding.txtJadwal.text = "Jadwal : \n"+jadwal
        binding.txtChair.text =  "Available "+chair.toString()
        binding.txtClass.text = status+" Class"
//        binding.ivKota.setImageResource(image)

        binding.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("destinasi", kota)
            bundle.putString("destinasi",kota)
            bundle.putString("departure",keberangkatan)
            bundle.putString("takeOff",jadwal)
            bundle.putInt("harga",harga)
            bundle.putInt("totalchair",chair)
            bundle.putString("class",status)
            bundle.putString("desCode",desCode)
            bundle.putString("depCode",depCode)
            bundle.putString("arrive",arrive)
            bundle.putString("flight",flight)
            bundle.putString("type",type)
            bundle.putInt("idTiket",idTiket)
            val intent = Intent(this, UpdateTiketActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }

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