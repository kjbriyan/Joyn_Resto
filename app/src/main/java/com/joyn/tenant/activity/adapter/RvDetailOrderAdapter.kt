package com.joyn.tenant.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.solver.widgets.Helper
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.model.InProgresModel
import kotlinx.android.synthetic.main.item_ordered.view.*

class RvDetailOrderAdapter :
    RecyclerView.Adapter<RvDetailOrderAdapter.viewHolder>() {

    private lateinit var list: MutableList<InProgresModel>

    fun updateData(list: MutableList<InProgresModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ordered, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(list[position])
    }

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: InProgresModel) {
            com.joyn.tenant.utils.Helper().debuger("Adapter : ${data.totPrice}")
            itemView.tv_name_menu.text = data.menuOrdred
            itemView.tv_price.text = data.totPrice
            itemView.tv_tot_price.text = data.totPrice
        }
    }
}