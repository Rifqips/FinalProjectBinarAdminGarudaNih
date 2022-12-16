package com.finpro.admingarudanih.view.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.databinding.FragmentListTransaksiBinding
import com.finpro.admingarudanih.databinding.FragmentListUserBinding


class ListTransaksiFragment : Fragment() {

    private lateinit var binding : FragmentListTransaksiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_transaksi, container, false)
    }
}