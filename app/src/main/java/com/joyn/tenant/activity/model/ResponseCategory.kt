package com.joyn.tenant.activity.model

import com.google.gson.annotations.SerializedName

data class ResponseCategory(

    @field:SerializedName("joyn_response")
    val joynResponse: JoynResponse? = null
)

data class JoynResponse(

    @field:SerializedName("result")
    val result: List<ResultItem?>? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)

data class ResultItem(

    @field:SerializedName("restaurant_menucat_name")
    val restaurantMenucatName: String? = null,

    @field:SerializedName("restaurant_menucat_id")
    val restaurantMenucatId: Int? = null,

    @field:SerializedName("restaurant_menucat_photo_url")
    val restaurantMenucatPhotoUrl: String? = null
)
