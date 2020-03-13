package com.joyn.tenant.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.model.OrderModel
import kotlinx.android.synthetic.main.list_item_order.view.*

class OrderItemAdapter(private var listItem: List<OrderModel>) :
    RecyclerView.Adapter<OrderItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_order, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(model: OrderModel) {
            with(itemView) {
                itemView.tv_nama_produk.text = model.nama
                itemView.tv_harga_produk.text = model.harga.toString()
            }
        }
    }
}