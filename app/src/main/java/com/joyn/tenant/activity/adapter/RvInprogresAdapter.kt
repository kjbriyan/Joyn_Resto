package com.joyn.tenant.activity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.DetailOrderActivity
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.list_order_item.view.*
import kotlin.coroutines.coroutineContext

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
//        holder.itemView.setOnClickListener {
//            val i = Intent(holder.itemView.context,DetailOrderActivity::class.java)
//            i.putExtra("total",list)
//            holder.itemView.context.startActivity(i)
//        }
    }

    inner class RvViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: InProgresModel) {

            itemView.setOnClickListener {
                val i = Intent(itemView.context,DetailOrderActivity::class.java)
                i.putExtra("total",data)

                itemView.context.startActivity(i)
            }

            itemView.tv_name.text = data.nameOrdered
            itemView.tv_name_driver.text = data.nameRider
            itemView.tv_plat_driver.text = data.platNumber
            itemView.tv_price.text = data.totPrice.toString()
            itemView.tv_status_paid.text = data.paidStatus
            itemView.tv_time.text = data.timeOrder

        }
    }
}


