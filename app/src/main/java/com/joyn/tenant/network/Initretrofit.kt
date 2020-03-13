package com.joyn.tenant.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Initretrofit {
    private val URL = "http://192.168.1.101/Restapi/index.php/api/"

    fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): ApiInterfaces {
        return initRetrofit().create(ApiInterfaces::class.java )
    }
}