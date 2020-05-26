package com.smk.futbol.data

import com.smk.futbol.base.BaseRepository
import com.smk.futbol.data.source.League
import com.smk.futbol.data.source.remote.LeagueRemoteDataSource

class LeagueRepository private constructor() : BaseRepository<LeagueRemoteDataSource>() {

    suspend fun getDetailLeague(idLeague: String): MutableList<League>? {
        return remoteDataStore?.getDetailLeague(idLeague)
    }

    companion object {
        val instance by lazy { LeagueRepository() }
    }
}