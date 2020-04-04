package com.joyn.tenant.activity.fragment.taborder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.RvInprogresAdapter
import com.joyn.tenant.activity.fragment.model.InProgresModel
import kotlinx.android.synthetic.main.fragment_inprogres.*
import kotlinx.android.synthetic.main.fragment_inprogres.view.*

/**
 * A simple [Fragment] subclass.
 */
class InprogresFragment : Fragment() {

    val list = ArrayList<InProgresModel>()
    val listUsers = arrayOf(
        "Google",
        "Apple",
        "Microsoft",
        "Asus",
        "Zenpone",
        "Acer"
    )
    val listUsers2 = arrayOf(
        "Google",
        "Apple",
        "Microsoft",
        "Asus",
        "uwaww",
        "Acer"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inprogres, container, false)
        view.rv_inprogres.setHasFixedSize(true)
        view.rv_inprogres.layoutManager = LinearLayoutManager(activity)
        intView()

        return view
    }

    fun intView(){


        for (i in 0 until listUsers.size){

            list.add(InProgresModel(listUsers.get(i),listUsers2.get(i),
                listUsers.get(i),listUsers2.get(i),
                listUsers.get(i),listUsers2.get(i)))

            if(listUsers.size - 1 == i){
                // init adapter yang telah dibuat tadi
                val adapter = RvInprogresAdapter(list)
                adapter.notifyDataSetChanged()

                //tampilkan data dalam recycler view
                rv_inprogres.adapter = adapter
            }

        }
    }

}
