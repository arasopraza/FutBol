package com.smk.futbol.data.source.remote

import com.smk.futbol.data.source.League
import com.smk.futbol.network.WebService

class LeagueRemoteDataSource(private val webService: WebService){

    suspend fun getDetailLeague(idLeague: String): MutableList<League>? {
        val response = webService.getDetailLeague(idLeague)
        if (response.isSuccessful) return response.body()?.leagues

        throw Exception("Something went wrong $response")
    }
}