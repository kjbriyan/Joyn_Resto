package com.joyn.tenant.activity.fragment.submit.model

data class TypeMenu(
    var typeMenu : String,
    var listMenu : MutableList<MenuItem>? = null
) : RestoItem