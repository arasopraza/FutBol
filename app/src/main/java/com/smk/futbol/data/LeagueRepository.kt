package com.smk.futbol.data

import com.smk.futbol.base.BaseRepository
import com.smk.futbol.data.source.LeagueDataSource
import com.smk.futbol.model.League

class LeagueRepository private constructor() : BaseRepository<LeagueDataSource>() {

    suspend fun getDetailLeague(idLeague: String): MutableList<League>? {
        return remoteDataStore?.getDetailLeague(idLeague)
    }

    companion object {
        val instance by lazy { LeagueRepository() }
    }
}