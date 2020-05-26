package com.smk.futbol.data.source.remote

import com.smk.futbol.data.source.Event
import com.smk.futbol.data.source.Team
import com.smk.futbol.network.WebService

class EventRemoteDataSource(private val webService: WebService) {

    suspend fun getPrevMatch(idLeague: String): MutableList<Event>? {
        val response = webService.getPrevMatch(idLeague)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    suspend fun getNextMatch(idLeague: String): MutableList<Event>? {
        val response = webService.getNextMatch(idLeague)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    suspend fun getSearchEvent(query: String): MutableList<Event>? {
        val response = webService.getSearchEvent(query)
        if (response.isSuccessful) return response.body()?.event

        throw Exception("Something went wrong $response")
    }

    suspend fun getDetailEvent(idEvent: String): MutableList<Event>? {
        val response = webService.getDetailEvent(idEvent)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    suspend fun getBadgeTeam(idTeam: String): MutableList<Team>? {
        val response = webService.getDetailTeam(idTeam)
        if (response.isSuccessful) return response.body()?.teams

        throw Exception("Something went wrong $response")
    }
}