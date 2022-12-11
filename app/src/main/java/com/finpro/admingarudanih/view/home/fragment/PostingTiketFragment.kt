package com.finpro.admingarudanih.view.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.adapter.AdapterTiket
import com.finpro.admingarudanih.databinding.FragmentPostingTiketBinding
import com.finpro.admingarudanih.viewmodel.TicketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostingTiketFragment : Fragment() {

    private lateinit var binding : FragmentPostingTiketBinding
    lateinit var tiketAdapter : AdapterTiket

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostingTiketBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTiketLokal()
        setTiketIntr()

    }

    fun setTiketLokal(){
        val viewModel = ViewModelProvider(requireActivity()).get(TicketViewModel::class.java)
        viewModel.getLdTiketLocal().observe(viewLifecycleOwner){
            if (it != null) {
                binding.rvLocal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                tiketAdapter = AdapterTiket(it.data.tickets)
                binding.rvLocal.adapter = tiketAdapter
            } else {
                Toast.makeText(requireActivity(), "Data Tidak Tampil", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.callTicketLocal()
    }
    fun setTiketIntr(){
        val viewModel = ViewModelProvider(requireActivity()).get(TicketViewModel::class.java)
        viewModel.getLdTiketIntr().observe(viewLifecycleOwner){
            if (it != null) {
                binding.rvInternational.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                tiketAdapter = AdapterTiket(it.data.tickets)
                binding.rvInternational.adapter = tiketAdapter
            } else {
                Toast.makeText(requireActivity(), "Data Tidak Tampil", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.callTicketIntr()
    }
}