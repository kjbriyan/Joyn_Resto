package com.joyn.tenant.activity.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.FragmentAdapter
import com.joyn.tenant.activity.fragment.taborder.InprogresFragment
import com.joyn.tenant.activity.fragment.taborder.PreviousOrderFragment
import kotlinx.android.synthetic.main.fragment_order.*


/**
 * A simple [Fragment] subclass.
 */
class OrderFragment : Fragment() {
    private var tblayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_order, container, false)
        tblayout = v.findViewById(R.id.tabLayout)
        viewPager = v.findViewById(R.id.viewPager)
        setFragment()
        return v
    }
    companion object{
        fun newIntance() : OrderFragment{
            return OrderFragment()
        }
    }
    fun setFragment(){

        val mFragment = FragmentAdapter(childFragmentManager)
        with(mFragment){
            this.addFragments(InprogresFragment(),"In Progres")
           this.addFragments(PreviousOrderFragment(),"Previous Order")
        }
        viewPager?.adapter = mFragment
        tblayout?.setupWithViewPager(viewPager)
        tblayout?.setSelectedTabIndicatorColor(Color.parseColor("#fd79a8"))

    }

}
