package com.joyn.tenant.activity.fragment.submit.webservice

import com.joyn.tenant.activity.fragment.submit.response.ResponseMenu
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers(
        "service: api-tenant",
        "client_key: JoynTenant@2020",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2NvZGUiOiJGLTAwMDAxIiwibmFtZSI6IlBhZWpvIiwicGhvbmUiOiI2Mjg1MzM2NjY2NjM5Iiwicm9sZSI6IlJFU1RBVVJBTlQiLCJjb2RlIjoiNWRhOThmZTA3NTUwIiwiaWF0IjoxNTg1NzYzNzM4LCJleHAiOjE2MTY4Njc3MzgsImlzcyI6ImxvY2FsaG9zdCJ9.7n65-1buGGlARCgoyVkVphtiSlK0jB7ZHcLIMmvdxtSiicNkYd0v4r9KaOEAhNIVQe8sRN_p37bNn71Ug40MHQ"
    )
    @GET("restaurant_auth/get_restaurant_menu")
    suspend fun get_restaurant_menu(): Response<ResponseMenu>

}