package com.joyn.tenant.utils

import com.joyn.tenant.R
import com.joyn.tenant.model.HomeMenuModel

class HomeMenu {

    private val name = arrayOf(
        "J-Shop",
        "J-Shop",
        "J-Shop",
        "J-Shop",
        "J-Shop",
        "J-Shop"
    )
    private val image = arrayOf(
        R.drawable.ic_j_shop,
        R.drawable.ic_j_shop,
        R.drawable.ic_j_shop,
        R.drawable.ic_j_shop,
        R.drawable.ic_j_shop,
        R.drawable.ic_j_shop
    )

    fun homeMenuList(): List<HomeMenuModel> {

        val listMenu = ArrayList<HomeMenuModel>()
        listMenu.add(HomeMenuModel(name[0], image[0]))
        listMenu.add(HomeMenuModel(name[1], image[1]))
        listMenu.add(HomeMenuModel(name[2], image[2]))
        listMenu.add(HomeMenuModel(name[3], image[3]))
        listMenu.add(HomeMenuModel(name[4], image[4]))
        listMenu.add(HomeMenuModel(name[5], image[5]))

        return listMenu
    }

}