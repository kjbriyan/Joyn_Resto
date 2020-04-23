package com.joyn.tenant.activity.webservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    private val BASE_URL = "http://dev.joyn-indonesia.com:2323/v1/"




    private val interceptor = HttpLoggingInterceptor().apply {
       this.level =  HttpLoggingInterceptor.Level.BODY
    }


    val client: OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val Instance: ApiInterface = retrofit.create(ApiInterface::class.java)
}