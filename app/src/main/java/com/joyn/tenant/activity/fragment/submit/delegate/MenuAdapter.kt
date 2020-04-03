package com.joyn.tenant.activity.fragment.submit.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import com.joyn.tenant.activity.fragment.submit.model.TypeMenu
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import kotlinx.android.synthetic.main.item_menu_resto.view.*

class MenuAdapter(val onItemClick: ((menu: TypeMenu) -> Unit)? = null) :
    AdapterDelegate<RestoItem> {


    override fun isForViewType(items: List<RestoItem>, position: Int): Boolean {
        return items[position] is TypeMenu
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        TypeMenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_menu_resto, parent, false)
        )

    override fun onBindViewHolder(
        items: List<RestoItem>,
        position: Int,
        holder: RecyclerView.ViewHolder
    ) {
        (holder as TypeMenuViewHolder).bindItem(items[position] as TypeMenu)
        holder.itemView.setOnClickListener { onItemClick?.invoke(items[position] as TypeMenu) }
    }

    class TypeMenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var adapter: ListFoodAdapter
        fun bindItem(data: TypeMenu) {
            itemView.tv_title_category.text = data.typeMenu

            data.listMenu?.let {
                adapter = ListFoodAdapter(it)
                itemView.rv_list_menu.adapter = adapter
            }
        }
    }
}