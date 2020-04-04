package com.joyn.tenant.activity.fragment.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.delegate.HeadRestoAdapter
import com.joyn.tenant.activity.fragment.submit.delegate.MenuAdapter
import com.joyn.tenant.activity.fragment.submit.model.HeadRestoItem
import com.joyn.tenant.activity.fragment.submit.model.MenuItem
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import com.joyn.tenant.activity.fragment.submit.model.TypeMenu
import com.joyn.tenant.utils.Helper
import com.joyn.tenant.utils.StaticData
import id.djaka.adapterdelegatedemo.core.adapterdelegate.GenericAdapter
import kotlinx.android.synthetic.main.fragment_submit.*

/**
 * A simple [Fragment] subclass.
 */
class SubmitFragment : Fragment() {

    companion object {
        fun newIntance(): SubmitFragment {
            return SubmitFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVIewModel()
        initRv()
    }

    private lateinit var vm: SubmitVIewModel
    private fun initVIewModel() {
        vm = ViewModelProvider(this).get(SubmitVIewModel::class.java)
        vm.dataStore.observe(viewLifecycleOwner, Observer(this@SubmitFragment::showData))

        vm.setHeadResto(
            StaticData.headResto
        )
        vm.setMenu(
            TypeMenu("Food", mutableListOf<MenuItem>())
        )
        vm.setMenu(
            TypeMenu("Drink", mutableListOf<MenuItem>())
        )
    }

    private lateinit var adapter: GenericAdapter<RestoItem>
    private fun initRv() {
        adapter = GenericAdapter()
        rv_submit_menu.adapter = adapter
        rv_submit_menu.setHasFixedSize(true)
        rv_submit_menu.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun showData(data: MutableList<RestoItem>) {
        Helper().debuger("Adapter $data")
        adapter.apply {
            addItems(data)
            addDelegate(HeadRestoAdapter())
            addDelegate(MenuAdapter { menu, index ->
                onClickMenuAdapter(menu, index)
            })
        }

    }

    private fun onClickMenuAdapter(typeMenu: TypeMenu, index: Int) {
//
        if (index == 1){
            vm.addMenu(
                index, StaticData.menuFood
            )

        }
            else {
            vm.addMenu(
                index, StaticData.menuDrink
            )
    }
}


private fun setData(menu: TypeMenu, index: Int) {
        Helper().debuger("Fragment $menu")
    }
}
