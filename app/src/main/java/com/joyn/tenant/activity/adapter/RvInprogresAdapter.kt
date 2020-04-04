package com.joyn.tenant.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.model.InProgresModel
import kotlinx.android.synthetic.main.list_order_item.view.*

class RvInprogresAdapter(private val list : ArrayList<InProgresModel>) : RecyclerView.Adapter<RvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_order_item,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.view.tv_name.text = list.get(position).nameOrdered
        holder.view.tv_name_driver.text = list.get(position).nameRider
        holder.view.tv_plat_driver.text = list.get(position).platNumber
        holder.view.tv_price.text = list.get(position).totPrice
        holder.view.tv_status_paid.text = list.get(position).paidStatus
        holder.view.tv_time.text = list.get(position).timeOrder
    }


}

class RvViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}
