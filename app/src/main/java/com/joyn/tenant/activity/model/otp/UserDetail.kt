package com.joyn.tenant.activity.model.otp

import com.google.gson.annotations.SerializedName

data class UserDetail(

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("token_exp")
	val tokenExp: Int? = null,

	@field:SerializedName("user_rek_name")
	val userRekName: String? = null,

	@field:SerializedName("token_iat")
	val tokenIat: Int? = null,

	@field:SerializedName("user_name")
	val userName: String? = null,

	@field:SerializedName("user_address")
	val userAddress: String? = null,

	@field:SerializedName("user_rek_bank")
	val userRekBank: String? = null,

	@field:SerializedName("user_longitude")
	val userLongitude: Double? = null,

	@field:SerializedName("user_kk")
	val userKk: String? = null,

	@field:SerializedName("user_latitude")
	val userLatitude: Double? = null,

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("refresh_token")
	val refreshToken: String? = null,

	@field:SerializedName("user_code")
	val userCode: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("user_phone")
	val userPhone: String? = null,

	@field:SerializedName("user_photo")
	val userPhoto: String? = null,

	@field:SerializedName("user_nik")
	val userNik: String? = null,

	@field:SerializedName("user_rek_no")
	val userRekNo: String? = null
)