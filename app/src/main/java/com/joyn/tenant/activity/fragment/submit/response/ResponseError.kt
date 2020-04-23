package com.joyn.tenant.activity.fragment.submit.response

import com.google.gson.annotations.SerializedName

data class ResponseError(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)