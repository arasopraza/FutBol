package com.smk.futbol.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventEntity(
    val dateEvent: String,
//    val dateEventLocal: Any,
//    val idAPIfootball: Any,
    val idAwayTeam: String,
    val idEvent: String,
    val idHomeTeam: String,
    val idLeague: String?,
    val idSoccerXML: String,
//    val intAwayScore: Any,
//    val intAwayShots: Any,
//    val intHomeScore: Any,
//    val intHomeShots: Any,
    val intRound: String,
//    val intSpectators: Any,
//    val strAwayFormation: Any,
    val strAwayGoalDetails: String,
    val strAwayLineupDefense: String,
    val strAwayLineupForward: String,
    val strAwayLineupGoalkeeper: String,
    val strAwayLineupMidfield: String,
    val strAwayLineupSubstitutes: String,
    val strAwayRedCards: String,
    val strAwayTeam: String,
    val strAwayYellowCards: String,
//    val strBanner: Any,
//    val strCircuit: Any,
//    val strCity: Any,
//    val strCountry: Any,
    val strDate: String,
//    val strDescriptionEN: Any,
    val strEvent: String,
    val strEventAlternate: String,
//    val strFanart: Any,
    val strFilename: String,
//    val strHomeFormation: Any,
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
//    val strMap: Any,
//    val strPoster: Any,
    val strPostponed: String,
//    val strResult: Any,
    val strSeason: String,
    val strSport: String,
//    val strTVStation: Any,
//    val strThumb: Any,
    val strTime: String,
    val strTimeLocal: String
//    val strTweet1: Any,
//    val strTweet2: Any,
//    val strTweet3: Any,
//    val strVideo: Any
) : Parcelable {
    data class EventResponse(
        val events: MutableList<EventEntity>
    )
}