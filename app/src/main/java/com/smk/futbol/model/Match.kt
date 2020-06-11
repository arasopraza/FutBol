package com.smk.futbol.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match(

    @SerializedName("strSport")
    val sport: String?,

    @SerializedName("dateEvent")
    val matchDate: String?,

    @SerializedName("idAwayTeam")
    val awayId: String,

    @SerializedName("idEvent")
    val matchId: String?,

    @SerializedName("idHomeTeam")
    val homeId: String,

    @SerializedName("idLeague")
    val leagueId: String? = null,

    @SerializedName("intAwayScore")
    val awayScore: String? = null,

    @SerializedName("intAwayShots")
    val awayShots: String? = null,

    @SerializedName("intHomeScore")
    val homeScore: String? = null,

    @SerializedName("intHomeShots")
    val homeShots: String? = null,

    @SerializedName("strAwayRedCards")
    val awayRedCards: String? = null,

    @SerializedName("strAwayTeam")
    val awayTeam: String,

    @SerializedName("strAwayYellowCards")
    val awayYellowCards: String? = null,

    @SerializedName("strDate")
    val date: String? = null,

    @SerializedName("strEvent")
    val matchName: String,

    @SerializedName("strHomeRedCards")
    val homeRedCards: String? = null,

    @SerializedName("strHomeTeam")
    val homeTeam: String,

    @SerializedName("strHomeYellowCards")
    val homeYellowCards: String? = null,

    @SerializedName("strLeague")
    val leagueName: String
) : Parcelable
