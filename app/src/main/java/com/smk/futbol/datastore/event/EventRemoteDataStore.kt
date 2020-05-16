package com.smk.futbol.datastore.event

import com.smk.futbol.model.Event
import com.smk.futbol.network.ApiService

@Suppress("UNREACHABLE_CODE")
class EventRemoteDataStore(private val apiService: ApiService) {
    @Throws(Exception::class)
    suspend fun getPrevMatch(idLeague: String): MutableList<Event> {
        val response = apiService.getPrevMatch(idLeague)
        return response.events

        throw Exception("Something went wrong $response")
    }

    suspend fun addAll(events: MutableList<Event>?) {
    }
}