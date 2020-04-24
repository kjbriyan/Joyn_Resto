package com.joyn.tenant.activity.fragment.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.joyn.tenant.R
import com.joyn.tenant.activity.category.CategoryActivity
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * A simple [Fragment] subclass.
 */
class Menu : Fragment() {

    companion object{
        fun newInstance() : Menu{
            return Menu()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        container_menu_setting.setOnClickListener {
            context?.startActivity(Intent(context, CategoryActivity::class.java))
        }
    }

}
