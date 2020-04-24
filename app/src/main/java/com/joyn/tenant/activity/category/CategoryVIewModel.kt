package com.joyn.tenant.activity.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joyn.tenant.activity.model.ResponseCategory
import com.joyn.tenant.activity.model.ResultItem
import com.joyn.tenant.activity.webservice.Retrofit
import com.joyn.tenant.utils.Helper
import kotlinx.coroutines.launch

class CategoryVIewModel : ViewModel(){

    private val _categoryMenu = MutableLiveData<MutableList<ResultItem>>()

    val categoryMenu get() = _categoryMenu

    init {
        getMenu()
    }

    private fun getMenu() = viewModelScope.launch {

        try {
            val response = Retrofit.Instance.get_category_menu()
            if (response.isSuccessful)
            _categoryMenu.value = response.body()?.joynResponse?.result as MutableList<ResultItem>
        }catch (e : Exception){
            Helper().debuger("VIewMOdel ___--> eeror ${e.message}")
        }

    }
        
}