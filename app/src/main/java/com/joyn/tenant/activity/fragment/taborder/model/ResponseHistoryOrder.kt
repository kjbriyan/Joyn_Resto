package com.joyn.tenant.activity.fragment.taborder.model

import com.google.gson.annotations.SerializedName

data class ResponseHistoryOrder(

	@field:SerializedName("joyn_response")
	val joynResponse: JoynResponse? = null
)