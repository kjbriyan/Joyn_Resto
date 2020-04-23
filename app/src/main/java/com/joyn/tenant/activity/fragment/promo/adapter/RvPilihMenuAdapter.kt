package com.joyn.tenant.activity.fragment.promo.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.promo.activity.BuatPromoActivity
import com.joyn.tenant.activity.fragment.promo.model.PromoModel
import kotlinx.android.synthetic.main.list_item_menu.view.*
import java.util.*
import kotlin.collections.ArrayList


class RvPilihMenuAdapter : RecyclerView.Adapter<RvPilihMenuAdapter.viewHolder>(), Filterable {
    private var list = ArrayList<PromoModel>()
    var item = ArrayList<PromoModel>()

    fun updateData(list: ArrayList<PromoModel>) {
        this.list = list
        item = list
        notifyDataSetChanged()
    }
    inner class viewHolder (view: View) : RecyclerView.ViewHolder(view){
        fun bind(data: PromoModel) {

            itemView.tv_name_menu.text = data.title
            itemView.tv_price_menu.text = data.price
            Glide.with(itemView)
                .load(data.image)
                .into(itemView.iv_menu)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_menu, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.cardView.setOnClickListener {
            val i = Intent(holder.itemView.context,BuatPromoActivity::class.java)
            i.putExtra("data",list.get(position))

            holder.itemView.context.startActivity(i)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    list = item
                } else {
                    val resultList = ArrayList<PromoModel>()
                    Log.d("data item",item.toString())
                    for (row in item) {
                        if (row.title?.toLowerCase(Locale.ROOT)?.contains(charSearch.toLowerCase(
                                Locale.ROOT))!!) {
                            resultList.add(row)
                        }
                    }
                    list = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = list
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                list = results?.values as ArrayList<PromoModel>
                notifyDataSetChanged()
            }

        }
    }
}