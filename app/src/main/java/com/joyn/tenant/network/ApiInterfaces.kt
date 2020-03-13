package com.joyn.tenant.network

import com.joyn.tenant.model.login.ResponseLogin
import com.joyn.tenant.model.register.ResponseRegister
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterfaces {

    @FormUrlEncoded
    @POST("login")
    open fun login(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Call<ResponseLogin>

    @Headers("Content-Type: application/json")
    @POST("register")
    open fun register(
        @Body params: RequestBody
    ): Call<ResponseRegister>


}