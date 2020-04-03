package com.joyn.tenant.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joyn.tenant.R
import kotlinx.android.synthetic.main.layout_field_login.*


class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    fun initView() {
        btn_getOtp.setOnClickListener {
            // login()
            val intent = Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }
        tv_register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegistrasiActivity::class.java)
            startActivity(intent)
        }
    }
}

