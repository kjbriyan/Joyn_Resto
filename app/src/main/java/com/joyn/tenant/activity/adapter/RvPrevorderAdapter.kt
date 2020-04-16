package com.joyn.tenant.activity.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.model.InProgresModel
import kotlinx.android.synthetic.main.list_order_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class RvPrevorderAdapter :
    RecyclerView.Adapter<RvPrevorderAdapter.RvViewHolder>(), Filterable {

    private var list = ArrayList<InProgresModel>()
    var item = ArrayList<InProgresModel>()

    fun updateData(list: ArrayList<InProgresModel>) {
        this.list = list
        item = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_prevorder_item,parent,false))
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
//            itemView.tv_status_paid.text = data.paidStatus
            itemView.tv_time.text = data.timeOrder

        }
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    list = item
                } else {
                    val resultList = ArrayList<InProgresModel>()
                    Log.d("data item",item.toString())
                    for (row in item) {
                        if (row.timeOrder?.toLowerCase(Locale.ROOT)?.contains(charSearch.toLowerCase(Locale.ROOT))!!) {
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
                list = results?.values as ArrayList<InProgresModel>
                notifyDataSetChanged()
            }

        }
    }
}



