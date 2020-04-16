package com.joyn.tenant.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joyn.tenant.R
import com.joyn.tenant.activity.model.login.ResponseLogin
import com.joyn.tenant.network.Initretrofit
import com.joyn.tenant.sharedpref.SharedPrefs
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.layout_field_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    fun initView() {
        Log.d(TAG, "prefs" + Prefs.getString(SharedPrefs().userPhone, ""))
        if (Prefs.getString(SharedPrefs().userPhone, "").equals(null)) {
            Log.d(TAG, "Please Login")
        } else {
            com.joyn.tenant.utils.Helper().moveActivity(this@LoginActivity, NavActivity::class.java)
            finish()
        }
        btn_getOtp.setOnClickListener {
            login()
        }

    }

    fun login() {
        val number = et_phoneNumber.text
        val goks = "{\"user_phone\":\"$number\"}"
        Log.d(TAG, goks)
        val init = Initretrofit().getInstance().login(goks)
        init.enqueue(object : Callback<ResponseLogin> {
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.d(TAG, t.message)
            }

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                val numberr = et_phoneNumber.text
                if (response.isSuccessful) {
                    val res = response.body()?.joynResponse
                    Log.d(TAG, res?.success.toString())
                    if (res?.success == true) {
                        Prefs.putString(SharedPrefs().userPhone, res.result?.userPhone)
                        val intent = Intent(this@LoginActivity, OtpActivity::class.java)
                        intent.putExtra("no", numberr.toString())
                        Log.d("intent nomer", numberr.toString())
                        startActivity(intent)
                        Log.d("sukses", response.message())
                    } else {
                        Toast.makeText(this@LoginActivity, res?.message, Toast.LENGTH_SHORT).show()
                        Log.d("gagal", res?.message)
                        Log.d("gagal", response.message())
                    }
                } else {
                    Toast.makeText(this@LoginActivity, response.message(), Toast.LENGTH_SHORT)
                        .show()
                    Log.d("fail", response.message())
                }
            }

        })
    }

}

