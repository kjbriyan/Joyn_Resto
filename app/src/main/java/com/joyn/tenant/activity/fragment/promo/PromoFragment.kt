package com.joyn.tenant.activity.fragment.promo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.activity.fragment.promo.activity.PilihMenuActivity
import com.joyn.tenant.activity.fragment.promo.adapter.RvPromoAdapter
import com.joyn.tenant.activity.fragment.promo.model.PromoModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.fragment_inprogres.*
import kotlinx.android.synthetic.main.fragment_promo.*

/**
 * A simple [Fragment] subclass.
 */
class PromoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_promo, container, false)
    }
    private val adapter = RvPromoAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floating_action_button.setOnClickListener { Helper().moveActivity(view.context,
            PilihMenuActivity::class.java) }


        val item = ArrayList<PromoModel>()
        item.add(data)
        item.add(data.copy(
            title = "Sate Ayam",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRuzU5Yu65zO9BeHJ81KIYWX1ei12CKL20oXaKcNvL6rlUDr8s0&usqp=CAU",
            price = "Rp 15.000",
            status = "Aktif"
        ))
        adapter.updateData(item)
        rv_list_promo_menu.setHasFixedSize(true)
        Helper().debuger("InProgress : ${item[0].title}")
        rv_list_promo_menu.adapter = adapter
    }

    private val data: PromoModel = PromoModel(
        "Ayam Geprek",
        "16 juli 2020 - 20 juli 2020",
        "Selesai",
        "https://sultantv.co/wp-content/uploads/2018/07/resep-ayam-geprek.jpg",
        "Rp 10.000"
    )
    companion object{
        fun newIntance() : PromoFragment {
            return PromoFragment()
        }
    }

}
