package com.joyn.tenant.activity.fragment.submit.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.response.MenusItem
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.item_list_menu.view.*

class ListFoodAdapter(private var items: MutableList<MenusItem>) :
    RecyclerView.Adapter<ListFoodAdapter.ViewHolder>() {
    var onItemClick: ((data: MenusItem) -> Unit)? = null

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


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(menu: MenusItem) {
            Glide.with(itemView.img_menu.context)
                .load(menu.restaurantMenuPhotoUrl)
                .apply(
                    RequestOptions().placeholder(R.drawable.img_no_image)
                        .error(R.drawable.img_no_image)
                )
                .into(itemView.img_menu)
            itemView.tv_title_menu.text = menu.restaurantMenuName
            itemView.tv_isavaible.text = "Avaible"
            itemView.tv_desc_menu.text = menu.restaurantMenuDesc
            itemView.tv_price_menu.text = "Rp. ${menu.restaurantMenuPrice}"
            itemView.setOnClickListener {
                onItemClick?.invoke(menu)
                Helper().debuger("List FOod on Click")
            }
        }
    }

}