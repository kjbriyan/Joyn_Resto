package com.joyn.tenant.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.RvDetailOrderAdapter
import com.joyn.tenant.activity.fragment.model.InProgresModel
import kotlinx.android.synthetic.main.activity_detail_order.*
import kotlinx.android.synthetic.main.header_detail_order.*

class DetailOrderActivity : AppCompatActivity() {
    private val adapter = RvDetailOrderAdapter()

    val TAG = "DetailOrderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_order)

        val dataa = intent.getParcelableExtra<InProgresModel>("total")

        adapter.updateData(data)
        rv_list_ordered.setHasFixedSize(true)
        rv_list_ordered.adapter = adapter

        intView()
//        val text  = intent.getParcelableArrayListExtra<InProgresModel>("total")
//        Log.d(TAG, "${text.size}")

        tv_name_order.text = dataa.nameOrdered
        tv_time_order.text = dataa.timeOrder
        tv_plat_driver.text = dataa.platNumber
        tv_total.text = dataa.totPrice

        Log.d(TAG, dataa.menuOrdred)

    }

    @SuppressLint("ResourceAsColor")
    fun intView() {
        val btn = intent.getStringExtra("btn")
        if (btn!=null) {
            if (btn.equals("Prev")) {
                btn_paid.visibility = View.GONE
            } else {
                Log.d(TAG,"tidak ada button")
            }
        }else{
            Log.d(TAG,"null")
            btn_paid.setOnClickListener {
                btn_paid.text = "Finish"
                btn_paid.setBackgroundColor(resources.getColor(R.color.textColorRed))
            }
        }
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
