package com.joyn.tenant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joyn.tenant.R
import com.joyn.tenant.model.HomeMenuModel
import kotlinx.android.synthetic.main.list_item_home_menu.view.*

class HomeAdapter(private val homeMenu: List<HomeMenuModel>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_home_menu, parent, false)

        return HomeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return homeMenu.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(homeMenu[position])
    }

    inner class HomeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(menu: HomeMenuModel) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(menu.icon)
                    .into(img_icon_home)

                tv_name_menu.text = menu.nama
            }
        }
    }

    interface OnItemClick {
        fun OnClick(position: Int)
    }

}