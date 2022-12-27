package com.finpro.admingarudanih.view.home.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.finpro.admingarudanih.databinding.FragmentTambahAdminBinding
import com.finpro.admingarudanih.view.home.HomeActivity
import com.finpro.admingarudanih.viewmodel.AdminViewModel
import com.finpro.admingarudanih.viewmodel.AuthViewModel
import com.finpro.admingarudanih.viewmodel.TicketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TambahAdminFragment : Fragment() {

    private lateinit var binding : FragmentTambahAdminBinding
    private lateinit var adminViewModel : AdminViewModel
    private lateinit var authViewModel: AuthViewModel
    private var tokenAdmin : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahAdminBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adminViewModel = ViewModelProvider(requireActivity()).get(AdminViewModel::class.java)
        authViewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        authViewModel.getToken().observe(requireActivity()){token->
            if (token != null){
                tokenAdmin = "Bearer "+token
            }
        }

        binding.ivBackDetail.setOnClickListener {
            startActivity(Intent(context,HomeActivity::class.java))
        }
        formValidataion()

        binding.btnRegister.setOnClickListener{
            val saveName = binding.etUsername.text.toString()
            val saveEmail = binding.etEmail.text.toString()
            val savePw = binding.etPassword.text.toString()
            val saveUpw = binding.etConfPassword.text.toString()
            registerAdmin(tokenAdmin,saveName, saveEmail, savePw)
        }

        binding.etPassword.addTextChangedListener{
            if (isPasswordValid) {
                validate()
                binding.passwordInputLayout.error = null
            } else {
                binding.etPassword.error = "Must Have A-Z a-z 0-9"
            }
        }
    }
    private fun formValidataion(){
        binding.etConfPassword.addTextChangedListener { confirmPassword ->
            if (confirmPassword.toString() != binding.etPassword.text.toString()){
                binding.btnRegister.isClickable = false
                binding.passwordConfInputLayout.isEndIconVisible = false
                binding.etConfPassword.error ="Confirm password is not match"
            }else{
                binding.btnRegister.isClickable = true
                binding.passwordConfInputLayout.isEndIconVisible = true
            }
        }
    }

    private fun validate(){
        binding.etUsername.text.toString().isNotBlank()
                && binding.etPassword.text.toString().isNotBlank()
                && isPasswordValid
    }

    private val isPasswordValid: Boolean get(){
        val passText = binding.etPassword.text.toString()
        return passText.contains("[a-z]".toRegex())
                && passText.contains("[A-Z]".toRegex())
                && passText.contains("[0-9]".toRegex())
                && passText.length >= 5
    }

    fun registerAdmin(token : String, nama : String, email : String, password : String){
        adminViewModel.postDataAdmin(token,nama,email, password)
        adminViewModel.postAdmin.observe(requireActivity()){
            if (it != null){
                Toast.makeText(context,"add data admin sukses", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
            }
        }
        requireActivity().finish()
    }
}