package com.finpro.admingarudanih.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.finpro.admingarudanih.databinding.ItemGetUserBinding
import com.finpro.admingarudanih.model.getusers.DataUserItem
import com.finpro.admingarudanih.model.getusers.User
import com.finpro.admingarudanih.view.detail.DetailActivity

class AdapterGetUser(val listGetUser: List<User>): RecyclerView.Adapter<AdapterGetUser.ViewHolder>() {

    class ViewHolder(var binding : ItemGetUserBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGetUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvIdUser.text ="ID : " + listGetUser[position].id.toString()
        holder.binding.tvEmailUser.text = listGetUser[position].email
        holder.binding.tvUsername.text = listGetUser[position].name
        holder.binding.tvCreated.text = listGetUser[position].createdAt
        holder.binding.tvUpdated.text = listGetUser[position].updatedAt
        holder.binding.tvRoleUser.text = listGetUser[position].role
        holder.binding.tvPhone.text = listGetUser[position].phone
        Glide.with(holder.itemView.context)
            .load(listGetUser[position].image).into(holder.binding.ivSetImage)

        holder.binding.imgPoster.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("id", listGetUser[position].id)
            intent.putExtra("email", listGetUser[position].email)
            intent.putExtra("username", listGetUser[position].name)
            intent.putExtra("created", listGetUser[position].createdAt)
            intent.putExtra("update", listGetUser[position].updatedAt)
            intent.putExtra("role", listGetUser[position].role)
            intent.putExtra("phone", listGetUser[position].phone)
            intent.putExtra("image", listGetUser[position].image)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listGetUser.size
    }
}