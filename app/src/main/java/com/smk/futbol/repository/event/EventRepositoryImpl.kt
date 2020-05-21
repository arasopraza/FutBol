package com.smk.futbol.repository.event

import com.smk.futbol.data.Event
import com.smk.futbol.data.Match
import com.smk.futbol.network.ApiService

@Suppress("UNREACHABLE_CODE")
class EventRepositoryImpl(private val apiService: ApiService) {
    @Throws(Exception::class)
    suspend fun getPrevMatch(idLeague: String): MutableList<Event> {
        val response = apiService.getPrevMatch(idLeague)
        return response.events

        throw Exception("Something went wrong $response")
    }

    suspend fun getNextMatch(idLeague: String): MutableList<Event> {
        val response = apiService.getNextMatch(idLeague)
        return response.events
    }

    suspend fun getSearchEvent(query: String): MutableList<Event> {
        val response = apiService.getSearchEvent(query)
        return response.event
    }
}