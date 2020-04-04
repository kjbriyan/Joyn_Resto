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

//    private val adapter = GenericAdapter(StaticData.getStaticData).apply {
//        addDelegate(HeadRestoAdapter())
//        addDelegate(MenuAdapter { pos ->
//            setData(pos)
//        })
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVIewModel()
        initRv()
    }

    private lateinit var vm: SubmitVIewModel
    private fun initVIewModel() {
        vm = ViewModelProvider(this).get(SubmitVIewModel::class.java)
        vm.dataStore.observe(viewLifecycleOwner, Observer(this@SubmitFragment::showData))

        vm.setHeadResto(
            HeadRestoItem(
                "https://www.dimanaja.com/assets/images/cover/2d6918b4b983eb28d2508c0ab485f66b1ee8b17e.jpg",
                4.5,
                "fast food",
                "ChickBoss, Sukolilo",
                "08.00 - 22.00 WIB",
                "Jl. Arief Rahman Hakim No.24, Keputih, Kec. Sukolilo, Surabaya "
            )
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
                index, MenuItem(
                    "https://cdn.pixabay.com/photo/2015/04/20/13/25/burger-731298_960_720.jpg",
                    "Hamburger",
                    "adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan ditengahnya diisi dengan patty yang biasanya di ambil dari daging",
                    25000.00,
                    true
                ))

        }
            else {
            vm.addMenu(
                index, MenuItem(
                    "https://image.shutterstock.com/image-photo/coffee-cup-milk-heart-shape-600w-254774482.jpg",
                    "Capucino",
                    "Minuman kopi dengan rasa yang enak",
                    25000.00,
                    true
                )
            )
    }
}


private fun setData(menu: TypeMenu, index: Int) {
        Helper().debuger("Fragment $menu")
    }
}
