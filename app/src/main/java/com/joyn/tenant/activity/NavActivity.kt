package com.joyn.tenant.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.OrderFragment
import kotlinx.android.synthetic.main.activity_nav.*

class NavActivity : AppCompatActivity() {

    companion object {
        private const val ID_ORDER = 1
        private const val ID_CHAT = 2
        private const val ID_SUBMIIT = 3
        private const val ID_PROMO = 4
        private const val ID_ACCOUNT = 5
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)


        setFragment(OrderFragment.newIntance())
        navigation.add(MeowBottomNavigation.Model(1, R.drawable.iconorderactv))
        navigation.add(MeowBottomNavigation.Model(2, R.drawable.iconchat))
        navigation.add(MeowBottomNavigation.Model(3, R.drawable.iconsubmitactv))
        navigation.add(MeowBottomNavigation.Model(4, R.drawable.iconpromoactv))
        navigation.add(MeowBottomNavigation.Model(5, R.drawable.iconaccount))

        navigation.setOnClickMenuListener {
            when(it.id){
                1 -> setFragment(OrderFragment.newIntance())


                else-> ""
            }
        }
        navigation.show(1)
    }
    fun setFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, fragment, NavActivity.javaClass.simpleName)
            .commit()
    }
}
