package com.joyn.tenant.activity.fragment.submit.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import com.joyn.tenant.activity.fragment.submit.response.MenusItem
import com.joyn.tenant.activity.fragment.submit.response.ResultItem
import id.djaka.adapterdelegatedemo.core.adapterdelegate.AdapterDelegate
import kotlinx.android.synthetic.main.item_menu_resto.view.*

class FoodAdapter(
    private val onClick: ((param: String, id: String?, menu: MenusItem?) -> Unit)? = null
) :
    AdapterDelegate<RestoItem> {

    override fun isForViewType(items: List<RestoItem>, position: Int): Boolean {
        return items[position] is ResultItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        FoodViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_menu_resto, parent, false)
        )

    override fun onBindViewHolder(
        items: List<RestoItem>,
        position: Int,
        holder: RecyclerView.ViewHolder
    ) {
        (holder as FoodViewHolder).bindItem(items[position] as ResultItem)
    }

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var listFoodAdapter: ListFoodAdapter

        fun bindItem(data: ResultItem) {
            itemView.tv_title_category.text = data.restaurantMenucatName
            itemView.btn_add_menu.setOnClickListener {
                onClick?.invoke("add", "${data.restaurantMenucatId}", null)
            }
            data.menus?.let { menu ->
                listFoodAdapter = ListFoodAdapter(menu)
                itemView.rv_list_menu.adapter = listFoodAdapter
                listFoodAdapter.onItemClick = { _menu ->
                    onClick?.invoke("update", null, _menu)
                }
            }
        }
    }

}