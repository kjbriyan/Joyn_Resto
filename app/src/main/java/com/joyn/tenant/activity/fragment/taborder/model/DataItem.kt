package com.joyn.tenant.activity.fragment.taborder.model

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("order_code")
	val orderCode: String? = null,

	@field:SerializedName("driver_name")
	val driverName: String? = null,

	@field:SerializedName("order_date")
	val orderDate: String? = null,

	@field:SerializedName("driver_vehicle_plate_number")
	val driverVehiclePlateNumber: String? = null,

	@field:SerializedName("total_cost")
	val totalCost: Int? = null,

	@field:SerializedName("customer_name")
	val customerName: String? = null,

	@field:SerializedName("order_id")
	val orderId: Int? = null
)