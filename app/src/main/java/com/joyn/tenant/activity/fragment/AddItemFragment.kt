package com.joyn.tenant.activity.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.joyn.tenant.R
import com.joyn.tenant.activity.adapter.OrderItemAdapter
import com.joyn.tenant.activity.viewmodel.OrderVIewModel
import com.joyn.tenant.model.OrderModel
import kotlinx.android.synthetic.main.bottom_sheet_insert_item.*
import kotlinx.android.synthetic.main.fragment_add_item.*


/**
 * A simple [Fragment] subclass.
 */
class AddItemFragment : Fragment() {

    interface CallbackListener {
        fun OnClick(fragment: Fragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    private lateinit var viewModel: OrderVIewModel
    private lateinit var callbackListener: CallbackListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(activity as FragmentActivity).get(OrderVIewModel::class.java)
        rv_list_order.setHasFixedSize(true)
        rv_list_order.layoutManager = LinearLayoutManager(activity)

        viewModel.getListOrder().observe(viewLifecycleOwner, Observer {
            val adapter = OrderItemAdapter(it)
            rv_list_order.adapter = adapter

            var total: Double = 0.0
            for (item in it) {
                total += item.harga
            }
            tv_estimate_item.text = "Estimate (${it.size}) total Rp. $total"
        })

        btn_add_order.setOnClickListener { initBottomSheet() }
        btn_nex_to_review_order.setOnClickListener {
            callbackListener.OnClick(ReviewOrderFragment())
        }
    }

    private fun initBottomSheet() {
        val bottomsheet = BottomSheetBehavior.from(bottom_sheet_add_item)
        bottomsheet.isHideable = false
        bottomsheet.state = BottomSheetBehavior.STATE_EXPANDED

        btn_save_item.setOnClickListener {

            if (input_nama_produk.text.toString().length < 1) {
                input_nama_produk.error = "Harus di isi"
            } else if (input_harga_produk.text.toString().length < 1) {
                input_harga_produk.error = " Harus di isi"
            } else {
                viewModel.setOrder(
                    OrderModel(
                        input_nama_produk.text.toString(),
                        input_harga_produk.text.toString().toDouble()
                    )
                )

                bottomsheet.isHideable = true
                bottomsheet.state = BottomSheetBehavior.STATE_HIDDEN

                input_nama_produk.clearFocus()
                input_harga_produk.clearFocus()
                input_nama_produk.text.clear()
                input_harga_produk.text.clear()
            }
        }
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view!!.windowToken, 0)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CallbackListener) {
            callbackListener = context
        } else {
            throw  ClassCastException(
                activity.toString()
                        + " must implement MyInterface "
            )
        }
    }
}
