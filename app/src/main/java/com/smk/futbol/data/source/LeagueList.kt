package com.smk.futbol.data.league

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueList(
    var id: String,
    var name: String? = "",
    var image: Int? = 0
) :Parcelable