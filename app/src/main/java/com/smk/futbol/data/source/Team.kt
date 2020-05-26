package com.smk.futbol.data.source

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val idTeam: String,
    val strGender: String,
    val strLeague: String,
    val strManager: String,
    val strRSS: String,
    val strSport: String,
    val strTeam: String,
    val strTeamBadge: String,
    val strTeamBanner: String,
    val strTeamJersey: String,
    val strTeamLogo: String,
    val strTeamShort: String
): Parcelable