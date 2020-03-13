package com.joyn.tenant.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.AddItemFragment

class OrderActivity : AppCompatActivity(), AddItemFragment.CallbackListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        showFragment(AddItemFragment())
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .commit()
    }

    override fun OnClick(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container_fragment, fragment)
            .addToBackStack(null)
            .commit()
        Log.d("tag", "ceked")
    }
}

