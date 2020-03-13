package com.joyn.tenant.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrderModel(var nama: String, var harga: Double) : Parcelable