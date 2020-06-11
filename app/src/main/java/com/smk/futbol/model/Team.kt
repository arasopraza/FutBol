package com.smk.futbol.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(

    @SerializedName("idTeam")
    val teamId: String,

    @SerializedName("strTeam")
    val teamName: String,

    @SerializedName("strTeamBadge")
    val teamBadge: String
): Parcelable