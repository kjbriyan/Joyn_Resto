package com.joyn.tenant.activity.fragment.promo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoModel(
    val title : String?,
    val date : String?,
    val status : String?,
    val image : String?,
    val price : String?
): Parcelable