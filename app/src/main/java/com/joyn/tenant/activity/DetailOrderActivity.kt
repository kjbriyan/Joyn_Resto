package com.joyn.tenant.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.RvDetailOrderAdapter
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.activity_detail_order.*
import kotlinx.android.synthetic.main.header_detail_order.*
import kotlinx.android.synthetic.main.item_ordered.*
import kotlin.math.log

class DetailOrderActivity : AppCompatActivity() {
    private val adapter = RvDetailOrderAdapter()

    val TAG = "DetailOrderActivity"
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_order)

        val dataa = intent.getParcelableExtra<InProgresModel>("total")

        adapter.updateData(data)
        rv_list_ordered.setHasFixedSize(true)
        rv_list_ordered.adapter = adapter


        btn_paid.setOnClickListener {
            btn_paid.text = "Finish"
            btn_paid.setBackgroundColor(R.color.red)
        }
//        val text  = intent.getParcelableArrayListExtra<InProgresModel>("total")
//        Log.d(TAG, "${text.size}")

        tv_name_order.text = dataa.nameOrdered
        tv_time_order.text = dataa.timeOrder
        tv_plat_driver.text = dataa.platNumber
        tv_total.text = dataa.totPrice

        Log.d(TAG, dataa.menuOrdred)

    }

    private val data = mutableListOf<InProgresModel>(
        InProgresModel(
            "Alpinu",
            "Joko anwar ",
            "15.00",
            "not paid yet",
            " L 1500 Pl",
            "15000",
            "ayam geprek"
        )
    )
}
