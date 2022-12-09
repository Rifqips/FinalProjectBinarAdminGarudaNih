package com.finpro.admingarudanih.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.finpro.admingarudanih.databinding.ActivityHomeBinding
import com.finpro.admingarudanih.view.home.fragment.ListTiketFragment
import com.finpro.admingarudanih.view.home.fragment.PostingTiketFragment
import com.finpro.admingarudanih.view.home.fragment.TambahAdminFragment
import com.finpro.admingarudanih.view.home.fragment.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: androidx.appcompat.widget.Toolbar    // creating object of ToolBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set the references of the declared objects above
        pager = binding.viewPager
        tab = binding.tabs

        // To make our toolbar show the application
        // we need to give it to the ActionBar

        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(ListTiketFragment(), "List Tiket")
        adapter.addFragment(PostingTiketFragment(), "Posting Tiket")
        adapter.addFragment(TambahAdminFragment(), "Tambah Admin")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)
    }
}