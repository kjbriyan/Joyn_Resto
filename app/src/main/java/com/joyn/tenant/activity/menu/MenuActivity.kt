package com.joyn.tenant.activity.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.SubmitVIewModel
import com.joyn.tenant.activity.fragment.submit.delegate.FoodAdapter
import com.joyn.tenant.activity.fragment.submit.delegate.HeadRestoAdapter
import com.joyn.tenant.activity.fragment.submit.delegate.MenuAdapter
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import com.joyn.tenant.activity.fragment.submit.model.TypeMenu
import com.joyn.tenant.activity.fragment.submit.response.MenusItem
import com.joyn.tenant.utils.Helper
import com.joyn.tenant.utils.StaticData
import id.djaka.adapterdelegatedemo.core.adapterdelegate.GenericAdapter
import kotlinx.android.synthetic.main.fragment_submit.*

class MenuActivity : AppCompatActivity() {
    private lateinit var arg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_submit)

        arg = intent.getStringExtra("arg") as String
        initVIewModel()
        initRv()


    }

    private lateinit var vm: SubmitVIewModel
    private fun initVIewModel() {
        vm = ViewModelProvider(this).get(SubmitVIewModel::class.java)
        vm.dataStore.observe(this, Observer(this@MenuActivity::showData))
    }

    private lateinit var adapter: GenericAdapter<RestoItem>
    private fun initRv() {
        adapter = GenericAdapter()
        rv_submit_menu.adapter = adapter
        rv_submit_menu.setHasFixedSize(true)
        rv_submit_menu.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun showData(data: MutableList<RestoItem>) {
        Helper().debuger("Adapter $data")
        adapter.apply {
            addItems(data)
            addDelegate(HeadRestoAdapter())
            addDelegate(MenuAdapter())
            addDelegate(FoodAdapter { param, id, menu ->
                toAddMenu(param, id, menu)
            })
        }
    }

    private fun onClickMenuAdapter(typeMenu: TypeMenu, index: Int) {
//
        if (index == 1) {
            vm.addMenu(
                index, StaticData.menuFood
            )

        } else {
            vm.addMenu(
                index, StaticData.menuDrink
            )
        }
    }

    private fun toAddMenu(param: String, id: String?, menu: MenusItem?) {
        val intent = Intent(this@MenuActivity, AddMenuActivity::class.java)
        intent.putExtra("param", param)
        if (param.equals("add")) {
            intent.putExtra("id", id)
        } else {
            intent.putExtra("menu", menu)
        }
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        vm.refresh()
    }

}
