package com.joyn.tenant.activity.fragment.submit.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.model.MenuItem
import kotlinx.android.synthetic.main.item_list_menu.view.*

class ListFoodAdapter(private var items: MutableList<MenuItem>) :
    RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_menu, parent, false)
        )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(menu: MenuItem) {

            Glide.with(itemView.img_menu.context).load(menu.image).into(itemView.img_menu)
            itemView.tv_title_menu.text = menu.titleMenu
            itemView.tv_isavaible.text = "Avaible"
            itemView.tv_desc_menu.text = menu.descMenu
            itemView.tv_price_menu.text = "Rp. ${menu.price}"
        }
    }

}