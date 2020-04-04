package com.joyn.tenant.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.list_order_item.view.*

class RvInprogresAdapter :
    RecyclerView.Adapter<RvInprogresAdapter.RvViewHolder>() {

    private var list = ArrayList<InProgresModel>()

    fun updateData(list: ArrayList<InProgresModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_order_item,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(list[position])

    }

    inner class RvViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: InProgresModel) {
            itemView.tv_name.text = data.nameOrdered
            itemView.tv_name_driver.text = data.nameRider
            itemView.tv_plat_driver.text = data.platNumber
            itemView.tv_price.text = data.totPrice
            itemView.tv_status_paid.text = data.paidStatus
            itemView.tv_time.text = data.timeOrder
        }
    }
}


