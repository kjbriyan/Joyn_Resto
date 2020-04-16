package com.joyn.tenant.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Initretrofit {
    private val URL = "http://dev.joyn-indonesia.com:2323/v1/"

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