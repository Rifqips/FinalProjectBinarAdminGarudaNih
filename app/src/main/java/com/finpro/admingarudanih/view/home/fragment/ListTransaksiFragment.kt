package com.finpro.admingarudanih.view.home.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.finpro.admingarudanih.R
import com.finpro.admingarudanih.adapter.AdapterGetUser
import com.finpro.admingarudanih.adapter.AdapterTransaksi
import com.finpro.admingarudanih.databinding.FragmentListTransaksiBinding
import com.finpro.admingarudanih.databinding.FragmentListUserBinding
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import com.finpro.admingarudanih.viewmodel.UserViewModel


class ListTransaksiFragment : Fragment() {

    lateinit var userViewModel : UserViewModel
    lateinit var authViewModel : AuthViewModel
    lateinit var adapterHistory : AdapterTransaksi
    private var setTokenTransaksi : String = ""

    companion object {
        const val TAG = "List Transaksi Fragment"

    }

    private lateinit var binding : FragmentListTransaksiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListTransaksiBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        userViewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]

        authViewModel.getToken().observe(requireActivity()){token->
            if (token != null){
                setTokenTransaksi = "Bearer "+token
            }
        }
        userViewModel.getHistoryObserve().observe(requireActivity()){
            if (it != null){
                binding.rvTransaksi.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                adapterHistory = AdapterTransaksi(it.data!!.transaction)
                binding.rvTransaksi.adapter = adapterHistory
                Log.d(TAG, "onViewCreated: ${it.data!!.transaction}")
//                Toast.makeText(context, "Data Tampil", Toast.LENGTH_SHORT).show()
                adapterHistory.notifyDataSetChanged()
            }
        }
        userViewModel.historyUser(setTokenTransaksi)

    }
}