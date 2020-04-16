package com.joyn.tenant.activity.fragment.taborder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.RvInprogresAdapter
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.fragment_inprogres.*

/**
 * A simple [Fragment] subclass.
 */
class InprogresFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inprogres, container, false)

    }

    private val adapter = RvInprogresAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = ArrayList<InProgresModel>()
        item.add(data)
        item.add(data.copy(nameOrdered = "James",
            menuOrdred = "Pecel Lele",
            nameRider = "Rudi lohor"))


        adapter.updateData(item)
        rv_inprogres.setHasFixedSize(true)
        Helper().debuger("InProgress : ${item[0].nameOrdered}")
        rv_inprogres.adapter = adapter
    }

    private val data: InProgresModel = InProgresModel(
        "Alpinu",
        "Joko anwar ",
        "15.00",
        "not paid yet",
        " L 1500 Pl",
        "15000",
        "ayam geprek"
    )


}
