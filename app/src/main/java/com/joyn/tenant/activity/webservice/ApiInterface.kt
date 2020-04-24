package com.joyn.tenant.activity.webservice

import com.joyn.tenant.activity.fragment.submit.response.ResponseMenu
import com.joyn.tenant.activity.menu.AddMenuActivity
import com.joyn.tenant.activity.menu.AddMenuModel
import com.joyn.tenant.activity.model.JoynResponse
import com.joyn.tenant.activity.model.ResponseCategory
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @Headers(
        "service: api-tenant",
        "client_key: JoynTenant@2020",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2NvZGUiOiJGLTAwMDAxIiwibmFtZSI6IlBhZWpvIiwicGhvbmUiOiI2Mjg1MzM2NjY2NjM5Iiwicm9sZSI6IlJFU1RBVVJBTlQiLCJjb2RlIjoiNWRhOThmZTA3NTUwIiwiaWF0IjoxNTg1NzYzNzM4LCJleHAiOjE2MTY4Njc3MzgsImlzcyI6ImxvY2FsaG9zdCJ9.7n65-1buGGlARCgoyVkVphtiSlK0jB7ZHcLIMmvdxtSiicNkYd0v4r9KaOEAhNIVQe8sRN_p37bNn71Ug40MHQ"
    )
    @GET("restaurant_auth/get_restaurant_menu")
    suspend fun get_restaurant_menu(): Response<ResponseMenu>

    @Headers(
        "service: api-tenant",
        "client_key: JoynTenant@2020",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2NvZGUiOiJGLTAwMDAxIiwibmFtZSI6IlBhZWpvIiwicGhvbmUiOiI2Mjg1MzM2NjY2NjM5Iiwicm9sZSI6IlJFU1RBVVJBTlQiLCJjb2RlIjoiNWRhOThmZTA3NTUwIiwiaWF0IjoxNTg1NzYzNzM4LCJleHAiOjE2MTY4Njc3MzgsImlzcyI6ImxvY2FsaG9zdCJ9.7n65-1buGGlARCgoyVkVphtiSlK0jB7ZHcLIMmvdxtSiicNkYd0v4r9KaOEAhNIVQe8sRN_p37bNn71Ug40MHQ"
    )
    @GET("restaurant_auth/get_restaurant_menu_category")
    suspend fun get_category_menu(): Response<ResponseCategory>

    @Multipart
    @Headers(
        "service: api-tenant",
        "client_key: JoynTenant@2020",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2NvZGUiOiJGLTAwMDAxIiwibmFtZSI6IlBhZWpvIiwicGhvbmUiOiI2Mjg1MzM2NjY2NjM5Iiwicm9sZSI6IlJFU1RBVVJBTlQiLCJjb2RlIjoiNWRhOThmZTA3NTUwIiwiaWF0IjoxNTg1NzYzNzM4LCJleHAiOjE2MTY4Njc3MzgsImlzcyI6ImxvY2FsaG9zdCJ9.7n65-1buGGlARCgoyVkVphtiSlK0jB7ZHcLIMmvdxtSiicNkYd0v4r9KaOEAhNIVQe8sRN_p37bNn71Ug40MHQ"

    )
    @POST("restaurant_auth/add_restaurant_menu")
    suspend fun add_menu(@Part("data") menu : RequestBody): Response<JoynResponse>

    @Multipart
    @Headers(
        "service: api-tenant",
        "client_key: JoynTenant@2020",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2NvZGUiOiJGLTAwMDAxIiwibmFtZSI6IlBhZWpvIiwicGhvbmUiOiI2Mjg1MzM2NjY2NjM5Iiwicm9sZSI6IlJFU1RBVVJBTlQiLCJjb2RlIjoiNWRhOThmZTA3NTUwIiwiaWF0IjoxNTg1NzYzNzM4LCJleHAiOjE2MTY4Njc3MzgsImlzcyI6ImxvY2FsaG9zdCJ9.7n65-1buGGlARCgoyVkVphtiSlK0jB7ZHcLIMmvdxtSiicNkYd0v4r9KaOEAhNIVQe8sRN_p37bNn71Ug40MHQ"

    )
    @POST("restaurant_auth/edit_restaurant_menu")
    suspend fun updateMenu(@Part("data") menu : RequestBody): Response<JoynResponse>

    @Multipart
    @Headers(
        "service: api-tenant",
        "client_key: JoynTenant@2020",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2NvZGUiOiJGLTAwMDAxIiwibmFtZSI6IlBhZWpvIiwicGhvbmUiOiI2Mjg1MzM2NjY2NjM5Iiwicm9sZSI6IlJFU1RBVVJBTlQiLCJjb2RlIjoiNWRhOThmZTA3NTUwIiwiaWF0IjoxNTg1NzYzNzM4LCJleHAiOjE2MTY4Njc3MzgsImlzcyI6ImxvY2FsaG9zdCJ9.7n65-1buGGlARCgoyVkVphtiSlK0jB7ZHcLIMmvdxtSiicNkYd0v4r9KaOEAhNIVQe8sRN_p37bNn71Ug40MHQ"

    )
    @POST("restaurant_auth/delete_restaurant_menu")
    suspend fun deleteMenu(@Part("data") menu : RequestBody): Response<JoynResponse>

}