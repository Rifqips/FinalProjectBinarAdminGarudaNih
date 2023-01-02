package com.finpro.admingarudanih.view.home

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.finpro.admingarudanih.databinding.ActivityHomeBinding
import com.finpro.admingarudanih.view.auth.LoginActivity
import com.finpro.admingarudanih.view.home.fragment.*
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var authViewModel: AuthViewModel
    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: androidx.appcompat.widget.Toolbar    // creating object of ToolBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        // set the references of the declared objects above
        pager = binding.viewPager
        tab = binding.tabs

        // To make our toolbar show the application
        // we need to give it to the ActionBar

        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(ListUserFragment(), "List User")
        adapter.addFragment(PostingTiketFragment(), "Posting Tiket")
        adapter.addFragment(TambahAdminFragment(), "Tambah Admin")
        adapter.addFragment(ListTransaksiFragment(), "List Transaksi")


        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)

        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java).also {
                authViewModel.apply {
                    deleteToken()
                    deleteData()
                }
            })
            Toast.makeText(this,"Berhasil Logout", Toast.LENGTH_SHORT).show()
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