package com.joyn.tenant.activity.fragment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InProgresModel(
    val nameOrdered: String?,
    val nameRider: String?,
    val timeOrder : String?,
    val paidStatus: String?,
    val platNumber : String?,
    val totPrice : String?,
    val menuOrdred : String?
) : Parcelable
