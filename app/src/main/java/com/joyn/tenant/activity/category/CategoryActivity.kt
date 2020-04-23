package com.joyn.tenant.activity.category

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.joyn.tenant.R
import com.joyn.tenant.activity.menu.MenuActivity
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.activity_add_menu.*

class CategoryActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)

        actionBar?.title = "Category"

        val vm = ViewModelProvider(this).get(CategoryVIewModel::class.java)
        rv_category.setHasFixedSize(true)
        rv_category.addItemDecoration(
            DividerItemDecoration(
                this, LinearLayoutManager.VERTICAL
            )
        )
        vm.categoryMenu.observe(this, Observer { data ->
            adapter = CategoryAdapter(data)
            rv_category.adapter = adapter
            adapter.onItemClick = {
                moveAct(it)
            }
        })
    }

    private fun moveAct(arg : String){
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("arg", arg)
        startActivity(intent)
    }
}
