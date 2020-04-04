package com.joyn.tenant.activity.fragment.taborder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.RvInprogresAdapter
import com.joyn.tenant.activity.fragment.model.InProgresModel
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.fragment_inprogres.*

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
        return inflater.inflate(R.layout.fragment_inprogres, container, false)

    }

    private val adapter = RvInprogresAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = ArrayList<InProgresModel>()
        item.add(data)
        item.add(data)
        item.add(data)
        item.add(data)

        adapter.updateData(item)
        rv_inprogres.setHasFixedSize(true)
        Helper().debuger("InProgress : ${item[0].nameOrdered}")
        rv_inprogres.adapter = adapter
    }

    private val data: InProgresModel = InProgresModel(
        "anjeng",
        "Anjeng 2 ",
        "15.00",
        "utang",
        " pxss",
        "15000"
    )

    fun intView(){


        for (i in 0 until listUsers.size){

            list.add(InProgresModel(listUsers.get(i),listUsers2.get(i),
                listUsers.get(i),listUsers2.get(i),
                listUsers.get(i),listUsers2.get(i)))

            if(listUsers.size - 1 == i){
                // init adapter yang telah dibuat tadi
                //   val adapter = RvInprogresAdapter(list)
                adapter.notifyDataSetChanged()

                //tampilkan data dalam recycler view
                rv_inprogres.adapter = adapter
            }

        }
    }

}
