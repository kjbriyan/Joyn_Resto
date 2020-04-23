package com.joyn.tenant.activity.fragment.promo.activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.promo.model.PromoModel
import kotlinx.android.synthetic.main.activity_buat_promo.*
import kotlinx.android.synthetic.main.activity_pilih_menu.*
import kotlinx.android.synthetic.main.activity_pilih_menu.tolbar
import kotlinx.android.synthetic.main.fragment_previous_order.*
import kotlinx.android.synthetic.main.fragment_previous_order.ln_date_filter
import kotlinx.android.synthetic.main.list_item_menu.*
import java.util.*

class BuatPromoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_promo)
        tolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        tolbar.setTitle("Buat Promo")
        tolbar.setTitleTextColor(resources.getColor(R.color.white))
        tolbar.setNavigationOnClickListener{
            finish()
        }
        iv_next.visibility = View.INVISIBLE
        date()
        setView()
    }
    fun setView(){
        val data = intent.getParcelableExtra<PromoModel>("data")
        if (data!= null){
            tv_name_menu.text = data.title
            tv_price_menu.text = data.price
            Glide.with(this)
                .load(data.image)
                .into(iv_menu)
        }else{
            Log.d("datanull","datanull")
        }

    }

    fun date() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        tv_date_hingga.setOnClickListener {
            val dpd =
                this?.let { it1 ->
                    DatePickerDialog(
                        it1,
                        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                            val bulan = month+ 1
                            tv_date_hingga.setText(dayOfMonth.toString() + "/" + bulan + "/" + year)

                        },
                        year,
                        month,
                        day
                    )
                }
            dpd?.show()
        }
        tv_date_dari.setOnClickListener {
            val dpd =
                this?.let { it1 ->
                    DatePickerDialog(
                        it1,
                        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                            val bulan = month+ 1
                            tv_date_dari.setText(dayOfMonth.toString() + "/" + bulan + "/" + year)

                        },
                        year,
                        month,
                        day
                    )
                }
            dpd?.show()
        }
    }
}
