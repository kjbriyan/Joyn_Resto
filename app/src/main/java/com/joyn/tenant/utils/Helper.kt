package com.joyn.tenant.utils

import android.content.Context
import android.content.Intent

class Helper {

    fun moveActivity(context: Context, tujuan: Class<*>) {
        val i = Intent(context, tujuan)
        context.startActivity(i)
    }


}