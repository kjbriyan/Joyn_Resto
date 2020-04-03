package com.joyn.tenant.activity.fragment.submit.model

data class HeadRestoItem(
    var imgResto : String,
    var star: Double,
    var typeFood: String,
    var nameResto: String,
    var openHour: String,
    var address: String
) : RestoItem