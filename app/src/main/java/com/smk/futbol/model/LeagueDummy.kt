package com.smk.futbol.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueDummy(
    var id: String,
    var name: String? = "",
    var image: Int? = 0
) :Parcelable