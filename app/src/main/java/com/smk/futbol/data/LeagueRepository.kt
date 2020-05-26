package com.smk.futbol.data.repository.league

import com.smk.futbol.data.source.League
import com.smk.futbol.data.repository.BaseRepository

class LeagueRepository private constructor() : BaseRepository<LeagueRepositoryImpl>() {

    suspend fun getDetailLeague(idLeague: String): MutableList<League>? {
        return remoteDataStore?.getDetailLeague(idLeague)
    }

    companion object {
        val instance by lazy { LeagueRepository() }
    }
}