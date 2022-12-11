package com.finpro.admingarudanih.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.finpro.admingarudanih.databinding.ItemGetUserBinding
import com.finpro.admingarudanih.model.getusers.DataUserItem
import com.finpro.admingarudanih.model.getusers.User

class AdapterGetUser(val listGetUser: List<User>): RecyclerView.Adapter<AdapterGetUser.ViewHolder>() {

    class ViewHolder(var binding : ItemGetUserBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGetUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvIdUser.text = listGetUser[position].id.toString()
        holder.binding.tvEmailUser.text = listGetUser[position].email
        holder.binding.tvUsername.text = listGetUser[position].name
        holder.binding.tvCreated.text = listGetUser[position].createdAt
        holder.binding.tvUpdated.text = listGetUser[position].updatedAt
        holder.binding.tvRoleUser.text = listGetUser[position].role
        Glide.with(holder.itemView.context)
            .load(listGetUser[position].image).into(holder.binding.ivSetImage)
    }

    override fun getItemCount(): Int {
        return listGetUser.size
    }
}