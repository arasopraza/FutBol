package com.smk.futbol.repository.league

import com.smk.futbol.data.League
import com.smk.futbol.repository.BaseRepository

class LeagueRepository private constructor() : BaseRepository<LeagueRepositoryImpl>() {

    suspend fun getDetailLeague(idLeague: String): MutableList<League>? {
        return remoteDataStore?.getDetailLeague(idLeague)
    }

    companion object {
        val instance by lazy { LeagueRepository() }
    }
}