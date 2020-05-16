package com.smk.futbol.repository

import com.smk.futbol.datastore.league.LeagueRemoteDataStore
import com.smk.futbol.model.League

class LeagueRepository private constructor() : BaseRepository<LeagueRemoteDataStore>() {

    suspend fun getDetailLeague(idLeague: String): MutableList<League>? {
        return remoteDataStore?.getDetailLeague(idLeague)
    }

    companion object {
        val instance by lazy { LeagueRepository()}
    }
}