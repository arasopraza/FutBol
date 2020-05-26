package com.smk.futbol.data.source

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
//    val dateFirstEvent: String,
//    val idAPIfootball: String,
//    val idCup: String,
    @SerializedName("idLeague") val idLeague: String,
//    val idSoccerXML: String,
    @SerializedName("intFormedYear") val leagueFormedYear: String,
    @SerializedName("strBadge") val leagueBadge: String,
//    val strBanner: String,
//    val strComplete: String,
    @SerializedName("strCountry") val leagueCountry: String,
//    val strCurrentSeason: String,
    @SerializedName("strDescriptionEN") val leagueDesc: String,
//    val strDivision: String,
//    val strFacebook: String,
    @SerializedName("strLeague") val leagueName: String
//    val strLeagueAlternate: String,
//    val strPoster: String,
//    val strTwitter: String,
//    val strWebsite: String,
//    val strYoutube: String
) : Parcelable