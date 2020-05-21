package com.smk.futbol.data

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
    val intRound: String,
    val strAwayGoalDetails: String,
    val strAwayLineupDefense: String,
    val strAwayLineupForward: String,
    val strAwayLineupGoalkeeper: String,
    val strAwayLineupMidfield: String,
    val strAwayLineupSubstitutes: String,
    val strAwayRedCards: String,
    val strAwayTeam: String,
    val strAwayYellowCards: String,
    val strCountry: String,
    val strDate: String,
    val strEvent: String,
    val strEventAlternate: String,
    val strFilename: String,
    val strHomeGoalDetails: String,
    val strHomeLineupDefense: String,
    val strHomeLineupForward: String,
    val strHomeLineupGoalkeeper: String,
    val strHomeLineupMidfield: String,
    val strHomeLineupSubstitutes: String,
    val strHomeRedCards: String,
    val strHomeTeam: String,
    val strHomeYellowCards: String,
    val strLeague: String,
    val strLocked: String,
    val strPostponed: String,
    val strSeason: String,
    val strSport: String,
    val strTime: String,
    val strTimeLocal: String
) : Parcelable
