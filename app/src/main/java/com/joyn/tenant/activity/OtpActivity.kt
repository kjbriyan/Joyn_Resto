package com.joyn.tenant.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joyn.tenant.R
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.activity_otp.*

class OtpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        materialButton.setOnClickListener{
            Helper().moveActivity(this@OtpActivity,NavActivity::class.java)
        }

    }
}
