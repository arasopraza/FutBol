package com.smk.futbol.data.repository.league

import com.smk.futbol.data.source.League
import com.smk.futbol.network.WebService

@Suppress("UNREACHABLE_CODE")
class LeagueRepositoryImpl(private val webService: WebService){

    suspend fun getDetailLeague(idLeague: String): MutableList<League> {
        val response = webService.getDetailLeague(idLeague)
        return response.leagues

        throw Exception("Something went wrong $response")
    }
}