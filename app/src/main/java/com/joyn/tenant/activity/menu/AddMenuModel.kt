package com.joyn.tenant.activity.menu

import com.google.gson.annotations.SerializedName

data class AddMenuModel(

    @field:SerializedName("restaurant_menu_id")
    var restaurantMenuId: Int? = null,

    @field:SerializedName("restaurant_menucat_id")
    var restaurantMenucatId: Int? = null,

    @field:SerializedName("restaurant_menu_stock_count")
    var restaurantMenuStockCount: Int? = null,

    @field:SerializedName("restaurant_menu_stock_max")
    var restaurantMenuStockMax: Int? = null,

    @field:SerializedName("restaurant_menu_is_promo")
    var restaurantMenuIsPromo: Int? = null,

    @field:SerializedName("restaurant_menu_name")
    var restaurantMenuName: String? = null,

    @field:SerializedName("restaurant_menu_price")
    var restaurantMenuPrice: Int? = null,

    @field:SerializedName("restaurant_menu_photo_url")
    var restaurantMenuPhotoUrl: String? = null,

    @field:SerializedName("restaurant_menu_desc")
    var restaurantMenuDesc: String? = null,

    @field:SerializedName("restaurant_menu_promo_type")
    var restaurantMenuPromoType: String? = null,

    @field:SerializedName("restaurant_menu_promo_count")
    var restaurantMenuPromoCount: Int? = null
)
