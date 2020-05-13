package com.smk.futbol.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    val dateFirstEvent: String,
    val idAPIfootball: String,
    val idCup: String,
    val idLeague: String,
//    val idSoccerXML: String,
//    val intFormedYear: String,
//    val strBadge: String,
//    val strBanner: String,
//    val strComplete: String,
//    val strCountry: String,
//    val strCurrentSeason: String,
//    val strDescriptionEN: String,
//    val strDivision: String,
//    val strFacebook: String,
//    val strFanart1: String,
//    val strFanart2: String,
//    val strFanart3: String,
//    val strFanart4: String,
//    val strGender: String,
//    val strLeague: String,
//    val strLeagueAlternate: String,
//    val strLocked: String,
//    val strLogo: String,
    val strNaming: String
//    val strPoster: String,
//    val strSport: String,
//    val strTwitter: String,
//    val strWebsite: String,
//    val strYoutube: String
) : Parcelable {
    data class LeagueResponse(
        val leagues: MutableList<League>
    )
}