package com.joyn.tenant.activity.fragment.submit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joyn.tenant.activity.fragment.submit.model.HeadRestoItem
import com.joyn.tenant.activity.fragment.submit.model.MenuItem
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import com.joyn.tenant.activity.fragment.submit.model.TypeMenu
import com.joyn.tenant.utils.StaticData
import kotlinx.coroutines.launch

class SubmitVIewModel : ViewModel(){

    private val _dataStore = MutableLiveData<MutableList<RestoItem>>()
    private var _data: MutableList<RestoItem> = mutableListOf()
    private val _listMenu = mutableListOf<MenuItem>()
    private val _typeMenu: TypeMenu? = null

    val dataStore: LiveData<MutableList<RestoItem>> = _dataStore

    fun setHeadResto(resto: HeadRestoItem) = viewModelScope.launch {
        _data.add(resto)
        _dataStore.value = _data
    }

    init {
        setHeadResto(StaticData.headResto)
        setMenu(TypeMenu("Food", StaticData.listFood()))
        setMenu(TypeMenu("Drink", StaticData.listDrink()))
        setMenu(TypeMenu("Dhises", mutableListOf()))
        setMenu(TypeMenu("Snack", mutableListOf()))
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



}