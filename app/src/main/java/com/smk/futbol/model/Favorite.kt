package com.smk.futbol.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Favorite(
    val id: Long?,
    val matchId: String?,
    val matchDate: String?,
    val homeName: String?,
    val awayName: String?,
    val homeScore: String?,
    val awayScore: String?
): Parcelable {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "EVENT_ID"
        const val MATCH_DATE: String = "EVENT_DATE"
        const val HOME_NAME: String = "HOME_NAME"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_NAME: String = "AWAY_NAME"
        const val AWAY_SCORE: String = "AWAY_SCORE"
    }
}