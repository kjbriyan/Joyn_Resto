package com.joyn.tenant.activity.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joyn.tenant.model.OrderModel

class OrderVIewModel : ViewModel() {

    private var order: MutableLiveData<List<OrderModel>> = MutableLiveData()
    private var listItem = ArrayList<OrderModel>()

    fun setOrder(orderItem: OrderModel) {
        listItem.add(orderItem)
        order.postValue(listItem)
        Log.d("Set Order", "size $listItem.size")
    }

    fun getListOrder(): LiveData<List<OrderModel>> {
        return order
    }

}

