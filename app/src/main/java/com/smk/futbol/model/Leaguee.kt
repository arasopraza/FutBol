package com.smk.futbol.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leaguee (
    val name: String?,
    val image: Int?
):Parcelable