package com.joyn.tenant.activity.fragment.submit.model

data class MenuItem(
    var image : String,
    var titleMenu : String,
    var descMenu : String,
    var price : Double,
    var isAvaible : Boolean
) : RestoItem