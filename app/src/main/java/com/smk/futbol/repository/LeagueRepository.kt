package com.smk.futbol.repository

import com.smk.futbol.datastore.LeagueDataStore
import com.smk.futbol.model.League
import com.smk.futbol.network.ApiClient
import com.smk.futbol.network.ApiService
import retrofit2.Retrofit

class LeagueRepository private constructor() : BaseRepository<LeagueDataStore>() {

    suspend fun getDetailLeague(leagueId: String): MutableList<League>? {
        val response = remoteDataStore?.getDetailLeague(leagueId)
        return response
    }

    companion object {
        val instance by lazy { LeagueRepository()}
    }
}