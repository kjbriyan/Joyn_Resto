package com.joyn.tenant.utils

import com.joyn.tenant.activity.fragment.submit.model.HeadRestoItem
import com.joyn.tenant.activity.fragment.submit.model.MenuItem
import com.joyn.tenant.activity.fragment.submit.model.TypeMenu

object StaticData {

    val headResto = HeadRestoItem(
        "https://www.dimanaja.com/assets/images/cover/2d6918b4b983eb28d2508c0ab485f66b1ee8b17e.jpg",
        4.5,
        "fast food",
        "ChickBoss, Sukolilo",
        "08.00 - 22.00 WIB",
        "Jl. Arief Rahman Hakim No.24, Keputih, Kec. Sukolilo, Surabaya "
    )

    val menuFood = MenuItem(
        "https://cdn.pixabay.com/photo/2015/04/20/13/25/burger-731298_960_720.jpg",
        "Hamburger",
        "adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan ditengahnya diisi dengan patty yang biasanya di ambil dari daging",
        25000.00,
        true
    )

    val menuDrink = MenuItem(
        "https://image.shutterstock.com/image-photo/coffee-cup-milk-heart-shape-600w-254774482.jpg",
        "Capucino",
        "Minuman kopi dengan rasa yang enak",
        25000.00,
        true
    )

    fun add() {
        getStaticData.add(TypeMenu("makanan", null))
    }

    var getStaticData = mutableListOf(
        HeadRestoItem(
            "https://www.dimanaja.com/assets/images/cover/2d6918b4b983eb28d2508c0ab485f66b1ee8b17e.jpg",
            4.5,
            "fast food",
            "ChickBoss, Sukolilo",
            "08.00 - 22.00 WIB",
            "Jl. Arief Rahman Hakim No.24, Keputih, Kec. Sukolilo, Surabaya "
        ),
        TypeMenu(
            "Food",
            listFood()
        ),
        TypeMenu(
            "Drink",
            listDrink()
        ),
        TypeMenu(
            "Snack",
            listSnack()
        ),
        TypeMenu(
            "Side dish",
          null
        ),
        TypeMenu(
            "Other",
            null
        )
    )

    fun listFood(): MutableList<MenuItem> = mutableListOf(
        MenuItem(
            "https://cdn.pixabay.com/photo/2015/04/20/13/25/burger-731298_960_720.jpg",
            "Hamburger",
            "adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan ditengahnya diisi dengan patty yang biasanya di ambil dari daging",
            25000.00,
            true
        ),
        MenuItem(
            "https://cdn.pixabay.com/photo/2015/04/20/13/25/burger-731298_960_720.jpg",
            "Hamburger",
            "adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan ditengahnya diisi dengan patty yang biasanya di ambil dari daging",
            25000.00,
            true
        ),
        MenuItem(
            "https://cdn.pixabay.com/photo/2015/04/20/13/25/burger-731298_960_720.jpg",
            "Hamburger",
            "adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan ditengahnya diisi dengan patty yang biasanya di ambil dari daging",
            25000.00,
            true
        )
    )

    private fun listDrink() = mutableListOf<MenuItem>(
        MenuItem(
            "https://image.shutterstock.com/image-photo/coffee-cup-milk-heart-shape-600w-254774482.jpg",
            "Capucino",
            "Minuman kopi dengan rasa yang enak",
            25000.00,
            true
        ),
        MenuItem(
            "https://image.shutterstock.com/image-photo/coffee-cup-milk-heart-shape-600w-254774482.jpg",
            "Capucino",
            "Minuman kopi dengan rasa yang enak",
            25000.00,
            true
        ),
        MenuItem(
            "https://image.shutterstock.com/image-photo/coffee-cup-milk-heart-shape-600w-254774482.jpg",
            "Capucino",
            "Minuman kopi dengan rasa yang enak",
            25000.00,
            true
        )
    )

    private fun listSnack() = mutableListOf<MenuItem>(
        MenuItem(
            "https://www.tokomesin.com/wp-content/uploads/2017/09/3-Cara-Membuat-Kentang-Goreng-Lezat-Tanpa-Ribet-tokomesin.jpg",
            "Kentang Goreng",
            "Kentang yang dicincang dan digoreng renyah",
            15000.00,
            true
        ), MenuItem(
            "https://www.tokomesin.com/wp-content/uploads/2017/09/3-Cara-Membuat-Kentang-Goreng-Lezat-Tanpa-Ribet-tokomesin.jpg",
            "Kentang Goreng",
            "Kentang yang dicincang dan digoreng renyah",
            15000.00,
            true
        ),
        MenuItem(
            "https://www.tokomesin.com/wp-content/uploads/2017/09/3-Cara-Membuat-Kentang-Goreng-Lezat-Tanpa-Ribet-tokomesin.jpg",
            "Kentang Goreng",
            "Kentang yang dicincang dan digoreng renyah",
            15000.00,
            true
        ),
        MenuItem(
            "https://www.tokomesin.com/wp-content/uploads/2017/09/3-Cara-Membuat-Kentang-Goreng-Lezat-Tanpa-Ribet-tokomesin.jpg",
            "Kentang Goreng",
            "Kentang yang dicincang dan digoreng renyah",
            15000.00,
            true
        )
    )
}