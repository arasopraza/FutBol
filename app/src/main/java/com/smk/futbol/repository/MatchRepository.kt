package com.smk.futbol.repository

import com.smk.futbol.datastore.match.MatchDataStore
import com.smk.futbol.model.Event

class MatchRepository private constructor() : BaseRepository<MatchDataStore>() {

    suspend fun getPrevMatch(leagueId: String): MutableList<Event>? {
        val response = remoteDataStore?.getPrevMatch(leagueId)
        return response
    }

    companion object {
        val instance by lazy { MatchRepository() }
    }
}