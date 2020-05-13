package com.smk.futbol.repository

import com.smk.futbol.datastore.LeagueDataStore
import com.smk.futbol.model.League

class LeagueRepository private constructor() : BaseRepository<LeagueDataStore>() {
    suspend fun getDetailLeague(): MutableList<League>? {
        val response = remoteDataStore?.getDetailLeague()
        return response
    }

    companion object {
        val instance by lazy { LeagueRepository()}
    }
}