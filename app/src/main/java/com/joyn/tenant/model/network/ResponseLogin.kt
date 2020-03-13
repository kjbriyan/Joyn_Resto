package com.joyn.tenant.model.network

import com.google.gson.annotations.SerializedName


data class ResponseLogin(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)