package com.joyn.tenant.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joyn.tenant.R
import com.joyn.tenant.network.Initretrofit
import kotlinx.android.synthetic.main.layout_field_login.*
import org.json.JSONObject
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
        btn_getOtp.setOnClickListener {
           // login()
            val intent = Intent(this, NavActivity::class.java)
            startActivity(intent)
        }
        tv_register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegistrasiActivity::class.java)
            startActivity(intent)
        }
    }

//    fun login() {
//        val username = et_username.text
//        val password = et_password.text
//        var init = Initretrofit().getInstance().login(username.toString(), password.toString())
//        init?.enqueue(object : Callback<ResponseLogin?> {
//            override fun onFailure(call: Call<ResponseLogin?>, t: Throwable) {
//                Toast.makeText(applicationContext, "Failure", Toast.LENGTH_SHORT).show()
//                Log.d("onFailure", t.message)
//            }
//            override fun onResponse(all: Call<ResponseLogin?>, response: Response<ResponseLogin?>) {
//                val intentt = Intent(this@LoginActivity, HomeActivity::class.java)
//                if (response.isSuccessful) {
//                    startActivity(intentt)
//                    Log.d("ini sukes bos", response.message() + "=" + response.body())
//                    Toast.makeText(
//                        applicationContext,
//                        "Login " + response.message(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                } else {
//                    var jsonObject: JSONObject? = null
//                    jsonObject = JSONObject(response.errorBody()!!.string())
//                    Log.d("ini fail", jsonObject.toString())
//                    Toast.makeText(applicationContext, "User Not Found", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        })
//    }
}

