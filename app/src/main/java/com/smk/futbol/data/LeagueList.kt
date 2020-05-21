package com.smk.futbol.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueList(
    var id: String,
    var name: String? = "",
    var image: Int? = 0
) :Parcelable