package com.joyn.tenant.activity.fragment.submit.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.model.HeadRestoItem
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import kotlinx.android.synthetic.main.item_head_resto.view.*
import kotlinx.android.synthetic.main.item_list_menu.view.*

class HeadRestoAdapter : AdapterDelegate<RestoItem> {
    override fun isForViewType(items: List<RestoItem>, position: Int): Boolean {

        return items[position] is HeadRestoItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        HeadRestoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_head_resto, parent, false)
        )

    override fun onBindViewHolder(
        items: List<RestoItem>,
        position: Int,
        holder: RecyclerView.ViewHolder
    ) {
        (holder as HeadRestoViewHolder).bindItem(items[position] as HeadRestoItem)
    }


    class HeadRestoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(data: HeadRestoItem) {
            Glide.with(itemView.img_resto.context)
                .load(data.imgResto)
                .into(itemView.img_resto)
            itemView.tv_rating.text = data.star.toString()
            itemView.tv_name_resto.text = data.nameResto
            itemView.tv_open_hour.text = data.openHour
            itemView.tv_type_food.text = data.typeFood
            itemView.tv_address_resto.text = data.address
        }
    }
}