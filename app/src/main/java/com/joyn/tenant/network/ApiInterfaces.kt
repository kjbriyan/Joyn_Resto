package com.joyn.tenant.network

import com.joyn.tenant.activity.fragment.taborder.model.ResponseHistoryOrder
import com.joyn.tenant.activity.model.login.ResponseLogin
import com.joyn.tenant.activity.model.otp.ResponseOtp
import retrofit2.Call
import retrofit2.http.*


interface ApiInterfaces {

    @Headers("client_key: JoynTenant@2020",
    "service: api-tenant")
    @FormUrlEncoded
    @POST("restaurant/login")
    open fun login(
        @Field("data") phonenumber : String?
    ): Call<ResponseLogin>

    @Headers("client_key: JoynTenant@2020",
        "service: api-tenant")
    @FormUrlEncoded
    @POST("restaurant/verify_code")
    open fun otp(
        @Field("data") otp : String?
    ): Call<ResponseOtp>

    @GET("restaurant_auth/get_order_history")
    open fun getOrderHistory():Call<ResponseHistoryOrder>

}