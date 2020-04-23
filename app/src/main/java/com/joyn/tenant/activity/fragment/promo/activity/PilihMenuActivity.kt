package com.joyn.tenant.activity.fragment.promo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.promo.adapter.RvPilihMenuAdapter
import com.joyn.tenant.activity.fragment.promo.adapter.RvPromoAdapter
import com.joyn.tenant.activity.fragment.promo.model.PromoModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.activity_pilih_menu.*
import kotlinx.android.synthetic.main.fragment_promo.*

class PilihMenuActivity : AppCompatActivity() {
    private val adapter = RvPilihMenuAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_menu)
        tolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        tolbar.setTitle("Pilih Menu")
        tolbar.setTitleTextColor(resources.getColor(R.color.white))
        tolbar.setNavigationOnClickListener{
            finish()
        }

        initview()
        filter()
    }
    fun filter(){
        et_search.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                adapter.filter.filter(s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
    fun initview(){
        val item = ArrayList<PromoModel>()
        item.add(data)
        item.add(data.copy(title = "Mie Asia"
        ,price = "Rp 30.000"
        ,image = "https://corporatetravel.id/wp-content/uploads/2016/09/featured-12.jpg"))
        item.add(data.copy(title = "Soto Ayam"
            ,price = "Rp 20.000"
            ,image = "https://www.masakapahariini.com/wp-content/uploads/2019/01/soto-ayam-kampung-780x440.jpg"))
        item.add(data.copy(title = "Pecel lele"
            ,price = "Rp 15.000"
            ,image = "https://s1.bukalapak.com/uploads/content_attachment/6af4c69320e8d76227ae45c5/w-744/resep_pecel_lele_2.jpg"))
        item.add(data.copy(title = "Lalapan"
            ,price = "Rp 20.000"
            ,image = "https://obs.line-scdn.net/0hEiCxl03xGkZ-ATHoQHdlEURXGSlNbQlFGjdLWC5vRHIGY1USQGRVKF1RFyVUYV0YEDdVI1sJAXcAMFkUEmdV/w644"))
        adapter.updateData(item)
        rv_pilih_menu.setHasFixedSize(true)
        Helper().debuger("pilih menu : ${item[0].title}")
        rv_pilih_menu.adapter = adapter
    }
    private val data: PromoModel = PromoModel(
        "Nasi Remas",
        "16 juli 2020 - 20 juli 2020",
        "Selesai",
        "https://i2.wp.com/resepmasakankuliner.com/wp-content/uploads/2010/09/sup-mi-cabai-merah.jpg",
        "Rp 20.000"
    )
}
