package com.smk.futbol.data.source.remote

import com.smk.futbol.data.source.Team
import com.smk.futbol.network.WebService

class EventDetailRemoteDataSource(private val webService: WebService) {

//    suspend fun getBadgeTeamHome(idTeam: String): MutableList<Team>? {
//        val response = webService.getDetailTeam(idTeam)
//        if (response.isSuccessful) return response.body()?.teams
//
//        throw Exception("Something went wrong $response")
//    }
}