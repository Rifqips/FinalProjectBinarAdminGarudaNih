package com.finpro.admingarudanih.view.home.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.finpro.admingarudanih.adapter.AdapterTiket
import com.finpro.admingarudanih.databinding.FragmentPostingTiketBinding
import com.finpro.admingarudanih.view.addnewtiket.TambahTiketActivity
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
        getAllData()
        setTiketLokal()
        setTiketIntr()

        binding.btnAdd.setOnClickListener {
            val intent = Intent(context, TambahTiketActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        setTiketLokal()
        setTiketIntr()
    }

    override fun onStart() {
        super.onStart()
        setTiketLokal()
        setTiketIntr()

    }

    override fun onPause() {
        super.onPause()
        setTiketLokal()
        setTiketIntr()
    }

    override fun onStop() {
        super.onStop()
        setTiketLokal()
        setTiketIntr()
    }



     private fun getAllData(){
         val swipeRefresh = binding.swipeRefresh
         swipeRefresh.setOnRefreshListener {
             if(swipeRefresh.isRefreshing){
                 setTiketLokal()
                 setTiketIntr()
                 swipeRefresh.isRefreshing = false
             }
         }

    }

    private fun setTiketLokal(){
        val viewModel = ViewModelProvider(requireActivity()).get(TicketViewModel::class.java)
        viewModel.getLdTiketLocal().observe(viewLifecycleOwner){
            if (it != null) {
                binding.rvLocal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                tiketAdapter = AdapterTiket(it.data.tickets)
                binding.rvLocal.adapter = tiketAdapter
                tiketAdapter.notifyDataSetChanged()
            } else {
//                Toast.makeText(requireActivity(), "", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.callTicketLocal()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun setTiketIntr(){
        val viewModel = ViewModelProvider(requireActivity()).get(TicketViewModel::class.java)
        viewModel.getLdTiketIntr().observe(viewLifecycleOwner){
            if (it != null) {
                binding.rvInternational.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                tiketAdapter = AdapterTiket(it.data.tickets)
                binding.rvInternational.adapter = tiketAdapter
                tiketAdapter.notifyDataSetChanged()
            } else {
//                Toast.makeText(requireActivity(), "", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.callTicketIntr()
    }
}