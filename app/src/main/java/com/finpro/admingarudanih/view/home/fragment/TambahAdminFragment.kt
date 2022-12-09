package com.finpro.admingarudanih.view.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.FragmentTambahAdminBinding

class TambahAdminFragment : Fragment() {

    private lateinit var binding : FragmentTambahAdminBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahAdminBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}