package com.joyn.tenant.activity.fragment.submit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.delegate.HeadRestoAdapter
import com.joyn.tenant.activity.fragment.submit.delegate.MenuAdapter
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

    private val adapter = GenericAdapter(StaticData.getStaticData).apply {
        addDelegate(HeadRestoAdapter())
        addDelegate(MenuAdapter { pos ->
            setData(pos)
        })
    }

    private fun setData() {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_submit_menu.adapter = adapter
        rv_submit_menu.setHasFixedSize(true)
        rv_submit_menu.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setData(menu: TypeMenu) {
        Helper().debuger("Fragment $menu")
    }
}
