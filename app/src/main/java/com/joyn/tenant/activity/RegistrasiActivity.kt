package com.joyn.tenant.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.joyn.tenant.R
import com.joyn.tenant.model.register.DataRegister
import com.joyn.tenant.model.register.ResponseRegister
import com.joyn.tenant.network.Initretrofit
import kotlinx.android.synthetic.main.layout_field_register.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistrasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)
        initview()
    }

    fun initview() {

        btn_register.setOnClickListener {
            val data = DataRegister(
                et_nama.text.toString(),
                et_username.text.toString(),
                et_password.text.toString()
            )
            val gson = Gson()
            val gs = gson.toJson(data)
            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = gs.toRequestBody(mediaType)
            register(requestBody)

        }
    }

    fun register(requestBody: RequestBody) {
        var init = Initretrofit().getInstance().register(requestBody)
        init?.enqueue(object : Callback<ResponseRegister?> {
            override fun onFailure(call: Call<ResponseRegister?>, t: Throwable) {
                Log.d("onFailure", t.message)
            }

            override fun onResponse(
                call: Call<ResponseRegister?>,
                response: Response<ResponseRegister?>
            ) {
                if (response.body()?.status.equals("true")) {
                    Toast.makeText(applicationContext, "Sukses Register", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "User sudah digunakan", Toast.LENGTH_SHORT)
                        .show()
                }

            }


        })
    }
}
