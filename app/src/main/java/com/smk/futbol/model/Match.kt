package com.smk.futbol.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(
    @SerializedName("strSport")
    val sport: String?,
    val dateEvent: String,
    val idAwayTeam: String,
    val idEvent: String,
    val idHomeTeam: String,
    val idLeague: String? = null,
    val intAwayScore: String? = null,
    val intAwayShots: String? = null,
    val intHomeScore: String? = null,
    val intHomeShots: String? = null,
    val strAwayRedCards: String? = null,
    val strAwayTeam: String,
    val strAwayYellowCards: String? = null,
    val strDate: String? = null,
    val strEvent: String,
    val strHomeRedCards: String? = null,
    val strHomeTeam: String,
    val strHomeYellowCards: String? = null,
    val strLeague: String
) : Parcelable
