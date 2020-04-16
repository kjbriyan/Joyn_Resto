package com.joyn.tenant.activity.model.otp

import com.google.gson.annotations.SerializedName

data class Result(

	@field:SerializedName("user_detail")
	val userDetail: UserDetail? = null,

	@field:SerializedName("restaurant_detail")
	val restaurantDetail: RestaurantDetail? = null
)