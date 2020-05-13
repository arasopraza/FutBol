package com.smk.futbol

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leaguee (
    val name: String?,
    val image: Int?
):Parcelable