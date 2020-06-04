package com.smk.futbol.data.source.remote

import com.smk.futbol.data.source.MatchDataSource
import com.smk.futbol.model.Match
import com.smk.futbol.model.Team
import com.smk.futbol.network.WebService

class MatchRemoteDataSource(private val webService: WebService) :
    MatchDataSource {

    override suspend fun getPrevMatch(idLeague: String): MutableList<Match>? {
        val response = webService.getPrevMatch(idLeague)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    override suspend fun getNextMatch(idLeague: String): MutableList<Match>? {
        val response = webService.getNextMatch(idLeague)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    override suspend fun getSearchMatch(query: String): MutableList<Match>? {
        val response = webService.getSearchMatch(query)
        if (response.isSuccessful) return response.body()?.event

        throw Exception("Something went wrong $response")
    }

    override suspend fun getDetailMatch(idMatch: String): MutableList<Match>? {
        val response = webService.getDetailMatch(idMatch)
        if (response.isSuccessful) return response.body()?.events

        throw Exception("Something went wrong $response")
    }

    override suspend fun getDetailTeam(idTeam: String): MutableList<Team>? {
        val response = webService.getDetailTeam(idTeam)
        if (response.isSuccessful) return response.body()?.teams

        throw Exception("Something went wrong $response")
    }


}