package com.joyn.tenant.activity.fragment.submit.response

import com.google.gson.annotations.SerializedName
import com.joyn.tenant.activity.fragment.submit.model.RestoItem


data class ResponseMenu(

    @field:SerializedName("joyn_response")
    val joynResponse: JoynResponse? = null
)

data class JoynResponse(

    @field:SerializedName("result")
    val result: MutableList<ResultItem?>? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
) : RestoItem


