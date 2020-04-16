package com.joyn.tenant.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.joyn.tenant.R

/**
 * A simple [Fragment] subclass.
 */
class AcountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acount, container, false)
    }
    companion object{
        fun newIntance() : AcountFragment{
            return AcountFragment()
        }
    }

}
