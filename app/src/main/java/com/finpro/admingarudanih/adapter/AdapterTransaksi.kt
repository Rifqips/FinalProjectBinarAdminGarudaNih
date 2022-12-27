package com.finpro.admingarudanih.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.finpro.admingarudanih.databinding.ItemtransaksiBinding
import com.finpro.admingarudanih.model.transaksi.Transaction

class AdapterTransaksi(val listTransaksi: List<Transaction?>): RecyclerView.Adapter<AdapterTransaksi.ViewHolder>() {
    class ViewHolder(var binding: ItemtransaksiBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemtransaksiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.binding.txtDestination.text = listTransaksi[position]!!.ticketCode
        holder.binding.txtNoKursi.text = listTransaksi[position]!!.numChair.toString()
       // holder.binding.txtClassHistory.text = listTransaksi[position]!!.code
        holder.binding.txtOrderBy.text = "Order By : "+ listTransaksi[position]!!.orderBy
        holder.binding.txtTglOrder.text = listTransaksi[position]!!.createdAt
        holder.binding.txtIsPaid.text = listTransaksi[position]!!.isPaid.toString()
        if (listTransaksi[position]!!.isPaid == false){
            holder.binding.txtIsPaid.text = "Belum Bayar"
        }else if (listTransaksi[position]!!.isPaid == true){
            holder.binding.txtIsPaid.text = "Sudah Bayar"
        }
        holder.binding.txtKtp.text = "Ktp Penumpang : "+ listTransaksi[position]!!.ktp

    }

    override fun getItemCount(): Int {
        return listTransaksi.size
    }
}