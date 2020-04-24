package com.joyn.tenant.activity.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.model.ResultItem
import kotlinx.android.synthetic.main.item_list_category.view.*

class CategoryAdapter(private val listCategory: MutableList<ResultItem>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var onItemClick: ((category: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_category, parent, false)
        )

    override fun getItemCount(): Int {
        return listCategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCategory[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(category: ResultItem) {
            itemView.tv_category_name.text = category.restaurantMenucatName
            itemView.setOnClickListener {
                onItemClick?.invoke(category.restaurantMenucatName!!)
            }
        }
    }

}