package com.smk.futbol.data.repository.event

import com.smk.futbol.data.source.Event
import com.smk.futbol.network.WebService

@Suppress("UNREACHABLE_CODE")
class EventRepositoryImpl(private val webService: WebService) {

    suspend fun getPrevMatch(idLeague: String): MutableList<Event>? {
        val response = webService.getPrevMatch(idLeague)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    suspend fun getNextMatch(idLeague: String): MutableList<Event> {
        val response = webService.getNextMatch(idLeague)
        return response.events

        throw Exception("Something went wrong $response")
    }

    suspend fun getSearchEvent(query: String): MutableList<Event> {
        val response = webService.getSearchEvent(query)
        return response.event

        throw Exception("Something went wrong $response")
    }

    suspend fun getDetailEvent(idEvent: String): MutableList<Event> {
        val response = webService.getDetailEvent(idEvent)
        return response.events

        throw Exception("Something went wrong $response")
    }
}