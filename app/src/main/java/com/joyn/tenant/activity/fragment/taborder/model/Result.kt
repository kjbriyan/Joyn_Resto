package com.joyn.tenant.activity.fragment.taborder.model

import com.google.gson.annotations.SerializedName

data class Result(

	@field:SerializedName("next_page")
	val nextPage: Int? = null,

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("last_page")
	val lastPage: Int? = null,

	@field:SerializedName("prev_page")
	val prevPage: Int? = null,

	@field:SerializedName("current_page")
	val currentPage: Int? = null
)