package com.smk.futbol.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueList(
    val id: String?,
    val name: String?,
    val image: Int?
) :Parcelable