package com.joyn.tenant.activity.model.login

import com.google.gson.annotations.SerializedName
import com.joyn.tenant.activity.model.login.JoynResponse

data class ResponseLogin(

	@field:SerializedName("joyn_response")
	val joynResponse: JoynResponse? = null
)