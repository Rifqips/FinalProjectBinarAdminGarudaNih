package com.finpro.admingarudanih.view.home.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.finpro.admingarudanih.adapter.AdapterGetUser
import com.finpro.admingarudanih.databinding.FragmentListUserBinding
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import com.finpro.admingarudanih.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListUserFragment : Fragment() {

    lateinit var userViewModel : UserViewModel
    lateinit var authViewModel : AuthViewModel
    lateinit var adapterHistory : AdapterGetUser
    private var setTokenUser : String = ""

    companion object {
        const val TAG = "List User Fragment"

    }

    private lateinit var binding : FragmentListUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListUserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        userViewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]

        authViewModel.getToken().observe(requireActivity()){token->
            if (token != null){
                setTokenUser = "Bearer "+token
            }
        }
        userViewModel.getCurrentObserve().observe(requireActivity()){
            if (it != null){
                binding.rvGetUser.layoutManager = LinearLayoutManager(context,
                    LinearLayoutManager.VERTICAL,false)
                adapterHistory = AdapterGetUser(it.data.user)
                binding.rvGetUser.adapter = adapterHistory
                Log.d(TAG, "onViewCreated: ${it.data.user}")
                Toast.makeText(context, "Data Tampil", Toast.LENGTH_SHORT).show()
                adapterHistory.notifyDataSetChanged()
            }
        }
        userViewModel.getUserToken(setTokenUser)
    }
}