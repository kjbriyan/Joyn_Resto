package com.joyn.tenant.activity.model.otp

import com.google.gson.annotations.SerializedName

data class RestaurantDetail(

	@field:SerializedName("restaurant_username")
	val restaurantUsername: Any? = null,

	@field:SerializedName("restaurant_longitude")
	val restaurantLongitude: Double? = null,

	@field:SerializedName("restaurant_id")
	val restaurantId: Int? = null,

	@field:SerializedName("insert_user")
	val insertUser: Any? = null,

	@field:SerializedName("restaurant_closing_timestamp")
	val restaurantClosingTimestamp: String? = null,

	@field:SerializedName("update_user")
	val updateUser: Any? = null,

	@field:SerializedName("is_deleted")
	val isDeleted: Int? = null,

	@field:SerializedName("delete_timestamp")
	val deleteTimestamp: Any? = null,

	@field:SerializedName("update_timestamp")
	val updateTimestamp: Any? = null,

	@field:SerializedName("promo_desc")
	val promoDesc: Any? = null,

	@field:SerializedName("restaurant_is_hide")
	val restaurantIsHide: Int? = null,

	@field:SerializedName("restaurant_phone")
	val restaurantPhone: String? = null,

	@field:SerializedName("insert_timestamp")
	val insertTimestamp: Any? = null,

	@field:SerializedName("restaurant_password")
	val restaurantPassword: Any? = null,

	@field:SerializedName("restaurant_address")
	val restaurantAddress: String? = null,

	@field:SerializedName("restaurant_photos_url")
	val restaurantPhotosUrl: String? = null,

	@field:SerializedName("restaurant_is_closed")
	val restaurantIsClosed: Int? = null,

	@field:SerializedName("restaurant_is_active")
	val restaurantIsActive: Int? = null,

	@field:SerializedName("restaurant_name")
	val restaurantName: String? = null,

	@field:SerializedName("restaurant_is_close_temporary")
	val restaurantIsCloseTemporary: Int? = null,

	@field:SerializedName("restaurant_category")
	val restaurantCategory: String? = null,

	@field:SerializedName("restaurant_code")
	val restaurantCode: String? = null,

	@field:SerializedName("restaurant_latitude")
	val restaurantLatitude: Double? = null,

	@field:SerializedName("restaurant_user_id")
	val restaurantUserId: Int? = null,

	@field:SerializedName("restaurant_photos_name")
	val restaurantPhotosName: String? = null,

	@field:SerializedName("delete_user")
	val deleteUser: Any? = null
)