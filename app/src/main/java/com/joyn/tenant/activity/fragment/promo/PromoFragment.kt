package com.joyn.tenant.activity.fragment.promo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.joyn.tenant.R
import com.joyn.tenant.activity.promo.PilihMenuActivity
import com.joyn.tenant.utils.Helper
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floating_action_button.setOnClickListener { Helper().moveActivity(view.context,PilihMenuActivity::class.java) }
    }
    companion object{
        fun newIntance() : PromoFragment {
            return PromoFragment()
        }
    }

}
