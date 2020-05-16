package com.smk.futbol.datastore.league

import com.smk.futbol.model.League
import com.smk.futbol.network.ApiService

@Suppress("UNREACHABLE_CODE")
class LeagueRemoteDataStore(private val apiService: ApiService){
    @Throws(Exception::class)
    suspend fun getDetailLeague(idLeague: String): MutableList<League> {
        val response = apiService.getDetailLeague(idLeague)
        return response.leagues

        throw Exception("Something went wrong $response")
    }
}