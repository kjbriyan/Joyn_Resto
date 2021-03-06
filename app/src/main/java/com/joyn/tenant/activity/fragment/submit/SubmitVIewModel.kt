package com.joyn.tenant.activity.fragment.submit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.joyn.tenant.activity.fragment.submit.model.HeadRestoItem
import com.joyn.tenant.activity.fragment.submit.model.MenuItem
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import com.joyn.tenant.activity.fragment.submit.model.TypeMenu
import com.joyn.tenant.activity.fragment.submit.response.ResponseError
import com.joyn.tenant.activity.fragment.submit.response.ResultItem
import com.joyn.tenant.activity.webservice.Retrofit
import com.joyn.tenant.utils.Helper
import com.joyn.tenant.utils.StaticData
import kotlinx.coroutines.launch

class SubmitVIewModel : ViewModel(){

    private val _dataStore = MutableLiveData<MutableList<RestoItem>>()
    private var _data: MutableList<RestoItem> = mutableListOf()

    val dataStore: LiveData<MutableList<RestoItem>> = _dataStore

    fun setHeadResto(resto: HeadRestoItem) = viewModelScope.launch {
        _data.add(resto)
        _dataStore.value = _data
    }

//    init {
//        setHeadResto(StaticData.headResto)
////        setMenu(TypeMenu("Food", StaticData.listFood()))
////        setMenu(TypeMenu("Drink", StaticData.listDrink()))
////        setMenu(TypeMenu("Dhises", mutableListOf()))
////        setMenu(TypeMenu("Snack", mutableListOf()))
//        getMenu()
//    }

    fun refresh(){
        _data.clear()
        getMenu()
    }

    fun setMenu(menu: TypeMenu) = viewModelScope.launch {
        _data.add(menu)
        _dataStore.value = _data
    }

    fun addMenu(typeIndex: Int, menu: MenuItem) = viewModelScope.launch {
        val typeMenu = _data[typeIndex] as TypeMenu
        typeMenu.listMenu?.add(menu)
        _data[typeIndex] = typeMenu
        _dataStore.value = _data
    }
    val listItem = mutableListOf<ResultItem>()
        private fun getMenu() = viewModelScope.launch {

        try {
            val response = Retrofit.Instance.get_restaurant_menu()
            Helper().debuger("VIewMOdel : ${response.code()}")
            if (response.isSuccessful) {
                val body = response.body()!!.joynResponse?.result as MutableList<ResultItem>

                _data.addAll(body)
                _dataStore.value = _data


            } else {
                val body = response.errorBody()
                val response = Gson().fromJson(body?.string(), ResponseError::class.java)
                    Helper().debuger("VIewMOdel : ${response.message}")
            }

        } catch (e: Exception) {
            Helper().debuger("VIewMOdel ___--> eeror ${e.message}")
        }


    }



}