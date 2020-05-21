package com.smk.futbol.repository.league

import com.smk.futbol.data.League
import com.smk.futbol.network.ApiService

@Suppress("UNREACHABLE_CODE")
class LeagueRepositoryImpl(private val apiService: ApiService){
    @Throws(Exception::class)
    suspend fun getDetailLeague(idLeague: String): MutableList<League> {
        val response = apiService.getDetailLeague(idLeague)
        return response.leagues

        throw Exception("Something went wrong $response")
    }
}