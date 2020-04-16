package com.joyn.tenant.activity.model.login

import com.google.gson.annotations.SerializedName

data class JoynResponse(

    @field:SerializedName("result")
	val result: Result? = null,

    @field:SerializedName("success")
	val success: Boolean? = null,

    @field:SerializedName("message")
	val message: String? = null
)