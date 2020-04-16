package com.joyn.tenant.activity.model.otp

import com.google.gson.annotations.SerializedName

data class ResponseOtp(

	@field:SerializedName("joyn_response")
	val joynResponse: JoynResponse? = null
)