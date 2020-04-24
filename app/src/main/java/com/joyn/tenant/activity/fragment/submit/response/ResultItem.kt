package com.joyn.tenant.activity.fragment.submit.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.joyn.tenant.activity.fragment.submit.model.RestoItem
import kotlinx.android.parcel.Parcelize

data class ResultItem(

    @field:SerializedName("restaurant_menucat_name")
    val restaurantMenucatName: String? = null,

    @field:SerializedName("restaurant_menucat_id")
    val restaurantMenucatId: Int? = null,

    @field:SerializedName("menus")
    val menus: MutableList<MenusItem>? = null,

    @field:SerializedName("restaurant_menucat_photo_url")
    val restaurantMenucatPhotoUrl: String? = null
) : RestoItem

@Parcelize
data class MenusItem(

    @field:SerializedName("restaurant_menucat_name")
    val restaurantMenucatName: String? = null,

    @field:SerializedName("restaurant_menucat_id")
    val restaurantMenucatId: Int? = null,

    @field:SerializedName("restaurant_menu_is_promo")
    val restaurantMenuIsPromo: Int? = null,

    @field:SerializedName("restaurant_menu_is_available")
    val restaurantMenuIsAvailable: Int? = null,

    @field:SerializedName("restaurant_menucat_photo_url")
    val restaurantMenucatPhotoUrl: String? = null,

    @field:SerializedName("restaurant_menu_price")
    val restaurantMenuPrice: Int? = null,

    @field:SerializedName("restaurant_menu_photo_url")
    val restaurantMenuPhotoUrl: String? = null,

    @field:SerializedName("restaurant_menu_promo_type")
    val restaurantMenuPromoType: String? = null,

    @field:SerializedName("restaurant_menu_stock_count")
    val restaurantMenuStockCount: Int? = null,

    @field:SerializedName("restaurant_menu_stock_max")
    val restaurantMenuStockMax: Int? = null,

    @field:SerializedName("restaurant_menu_id")
    val restaurantMenuId: Int? = null,

    @field:SerializedName("restaurant_menu_price_before_tax")
    val restaurantMenuPriceBeforeTax: Int? = null,

    @field:SerializedName("restaurant_menu_name")
    val restaurantMenuName: String? = null,

    @field:SerializedName("restaurant_menu_desc")
    val restaurantMenuDesc: String? = null,

    @field:SerializedName("restaurant_menu_promo_count")
    val restaurantMenuPromoCount: Int? = null
) : RestoItem, Parcelable