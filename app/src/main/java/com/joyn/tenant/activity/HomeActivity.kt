package com.joyn.tenant.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.joyn.tenant.R
import com.joyn.tenant.adapter.HomeAdapter
import com.joyn.tenant.utils.HomeMenu

class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val homeAdapter = HomeAdapter(HomeMenu().homeMenuList())
        val rv_home_menu = findViewById(R.id.rv_home_menu) as RecyclerView

        rv_home_menu.layoutManager = GridLayoutManager(this, 3)
        rv_home_menu.setHasFixedSize(true)
        rv_home_menu.adapter = homeAdapter

    }
}
