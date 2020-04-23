package com.joyn.tenant.activity.fragment.taborder

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.RvPrevorderAdapter
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.fragment_previous_order.*
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class PreviousOrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_order, container, false)
    }

    private val adapter = RvPrevorderAdapter()
    val item = ArrayList<InProgresModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        setData()
        adapter.updateData(item)
        adapter.getFilter()
        rv_prevOrder.setHasFixedSize(true)
        Helper().debuger("InProgress : ${item[0].nameOrdered}")
        rv_prevOrder.adapter = adapter

        filterdate()

    }

    fun filterdate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val bulan = month + 1
//        tv_date.setText(day.toString() + "/" + bulan + "/" + year)

        ln_date_filter.setOnClickListener {
            val dpd =
                activity?.let { it1 ->
                    DatePickerDialog(
                        it1,
                        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                            val bulan = month+ 1
                            tv_date.setText(dayOfMonth.toString() + "/" + bulan + "/" + year)
                            adapter.filter.filter(tv_date.text)
                        },
                        year,
                        month,
                        day
                    )
                }
            dpd?.show()
        }
    }

    fun setData(){
        item.add(data)
        item.add(
            data.copy(
                nameOrdered = "James",
                menuOrdred = "Pecel Lele",
                nameRider = "Rudi lohor"
            )
        )
        item.add(
            data.copy(
                nameOrdered = "James lor",
                menuOrdred = "Pecel tempe",
                nameRider = "Rudi tabuti",
                timeOrder = "9/4/2020"
            )
        )
        item.add(
            data.copy(
                nameOrdered = "Peter",
                menuOrdred = "Pecel Lele",
                nameRider = "Rudi lohor",
                timeOrder = "10/4/2020"
            )
        )
        item.add(
            data.copy(
                nameOrdered = "Joko anwar",
                menuOrdred = "Mie ayam",
                nameRider = "Bambang",
                timeOrder = "8/4/2020"
            )
        )
        item.add(
            data.copy(
                nameOrdered = "Dedi",
                menuOrdred = "Bakso",
                nameRider = "Lukas",
                timeOrder = "7/4/2020"
            )
        )
        item.add(
            data.copy(
                nameOrdered = "Joko pras",
                menuOrdred = "Mie ayam",
                nameRider = "Devi",
                timeOrder = "6/4/2020"
            )
        )
    }

     val data: InProgresModel = InProgresModel(
        "Alpinu",
        "Joko anwar ",
        "11/4/2020",
        "not paid yet",
        " L 1500 Pl",
        "15000",
        "ayam geprek"
    )
}
