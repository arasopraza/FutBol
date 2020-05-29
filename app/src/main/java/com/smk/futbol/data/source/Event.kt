package com.smk.futbol.data.source

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val dateEvent: String,
    val idAwayTeam: String,
    val idEvent: String,
    val idHomeTeam: String,
    val idLeague: String?,
    val intAwayScore: String?,
    val intAwayShots: String?,
    val intHomeScore: String?,
    val intHomeShots: String?,
    val strAwayGoalDetails: String?,
    val strAwayRedCards: String?,
    val strAwayTeam: String,
    val strAwayYellowCards: String?,
    val strDate: String?,
    val strEvent: String,
    val strHomeGoalDetails: String?,
    val strHomeRedCards: String?,
    val strHomeTeam: String,
    val strHomeYellowCards: String?,
    val strLeague: String
) : Parcelable
