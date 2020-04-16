package com.joyn.tenant.activity.model.login

import com.google.gson.annotations.SerializedName

data class Result(

	@field:SerializedName("expired")
	val expired: String? = null,

	@field:SerializedName("user_code")
	val userCode: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("user_phone")
	val userPhone: String? = null
)