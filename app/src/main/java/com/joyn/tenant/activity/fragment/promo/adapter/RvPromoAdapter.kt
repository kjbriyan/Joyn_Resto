package com.joyn.tenant.activity.fragment.promo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.activity.fragment.promo.activity.BuatPromoActivity
import com.joyn.tenant.activity.fragment.promo.model.PromoModel
import kotlinx.android.synthetic.main.list_promo_item.view.*

class RvPromoAdapter : RecyclerView.Adapter<RvPromoAdapter.viewHolder>() {
    private var list = ArrayList<PromoModel>()

    fun updateData(list: ArrayList<PromoModel>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvPromoAdapter.viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_promo_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RvPromoAdapter.viewHolder, position: Int) {
        holder.bind(list[position])
        if (list.get(position).status.equals("Selesai")){
            holder.itemView.btn_ulangi_promo.setOnClickListener {
                val i = Intent(holder.itemView.context,BuatPromoActivity::class.java)
                i.putExtra("data",list.get(position))
                holder.itemView.context.startActivity(i)
            }

        }else{
            holder.itemView.btn_ulangi_promo.visibility = View.INVISIBLE
            holder.itemView.tv_status_promo.setTextColor(holder.itemView.resources.getColor(R.color.colorPrimary))
        }
    }

    inner class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: PromoModel) {
            itemView.tv_name_menu.text = data.title
            itemView.tv_range_promo.text = data.date
            itemView.tv_status_promo.text = data.status
            Glide.with(itemView)
                .load(data.image)
                .into(itemView.iv_menu)


        }
    }
}
