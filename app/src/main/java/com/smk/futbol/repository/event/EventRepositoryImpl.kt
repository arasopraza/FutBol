package com.smk.futbol.datastore.event

import com.smk.futbol.data.EventEntity
import com.smk.futbol.network.ApiService

@Suppress("UNREACHABLE_CODE")
class EventRepositoryImpl(private val apiService: ApiService) {
    @Throws(Exception::class)
    suspend fun getPrevMatch(idLeague: String): MutableList<EventEntity> {
        val response = apiService.getPrevMatch(idLeague)
        return response.events

        throw Exception("Something went wrong $response")
    }

//    suspend fun getSearchEvent(query: String): MutableList<Event> {
//        val response = apiService.getSearchEvent(query)
//        return response.events
//    }
}