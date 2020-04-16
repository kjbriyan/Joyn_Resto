package com.joyn.tenant.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joyn.tenant.R
import com.joyn.tenant.activity.model.otp.ResponseOtp
import com.joyn.tenant.network.Initretrofit
import com.joyn.tenant.sharedpref.SharedPrefs
import com.joyn.tenant.utils.Helper
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpActivity : AppCompatActivity() {
    val TAG = "OtpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        val number = intent.getStringExtra("no") as String
        materialButton.setOnClickListener {
//            Helper().moveActivity(this,NavActivity::class.java)
            pushOtp(number)
        }


         Log.d(TAG,"no :"+number.toString())

    }

    fun pushOtp(no : String?) {
        val text = pinview.value
        val goks = "{\"user_phone\":\"$no\",\"code\":$text}"
        val init = Initretrofit().getInstance().otp(goks)
        init.enqueue(object : Callback<ResponseOtp> {
            override fun onFailure(call: Call<ResponseOtp>, t: Throwable) {
                Log.d(TAG, t.message)
            }
            override fun onResponse(call: Call<ResponseOtp>, response: Response<ResponseOtp>) {
                if (response.isSuccessful) {
                    val res = response.body()?.joynResponse
                    Log.d(TAG, res?.success.toString())
                    if (res?.success == true) {
                        Helper().moveActivity(this@OtpActivity, NavActivity::class.java)
                        Prefs.putString(SharedPrefs().userPhone,res.result?.userDetail?.userPhone.toString())
                        Log.d("sukses", response.message())
                    } else {
                        Toast.makeText(this@OtpActivity, res?.message, Toast.LENGTH_SHORT).show()
                        Log.d("gagal", res?.message)
                        Log.d("gagal", response.message())
                    }
                } else {
                    Toast.makeText(this@OtpActivity, response.message(), Toast.LENGTH_SHORT).show()
                    Log.d("fail", response.message())
                }
            }

        })
    }
}
