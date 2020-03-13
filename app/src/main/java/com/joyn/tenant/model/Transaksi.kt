package com.joyn.tenant.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
class Transaksi : Parcelable {

    @IgnoredOnParcel
    private lateinit var id_pelanggan: String
    @IgnoredOnParcel
    private lateinit var start_latitude: String
    @IgnoredOnParcel
    private lateinit var start_longitude: String
    @IgnoredOnParcel
    private lateinit var end_latitude: String
    @IgnoredOnParcel
    private lateinit var end_longitude: String
    @IgnoredOnParcel
    private lateinit var jarak: String
    @IgnoredOnParcel
    private lateinit var harga: String
    @IgnoredOnParcel
    private lateinit var alamat_asal: String
    @IgnoredOnParcel
    private lateinit var alamat_tujuan: String

}