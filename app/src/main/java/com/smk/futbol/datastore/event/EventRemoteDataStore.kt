package com.smk.futbol.datastore.match

import com.smk.futbol.model.Event
import com.smk.futbol.network.ApiService

class MatchRemoteDataStore(private var apiService: ApiService) : MatchDataStore {
    override suspend fun getPrevMatch(leagueId: String): MutableList<Event>? {
        val response = apiService.getPrevMatch(leagueId)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong ${response.code()}")
    }

    override suspend fun addAll(events: MutableList<Event>?) {
    }
}