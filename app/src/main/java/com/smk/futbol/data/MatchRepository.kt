package com.smk.futbol.data

import com.smk.futbol.base.BaseRepository
import com.smk.futbol.data.source.MatchDataSource
import com.smk.futbol.model.Match
import com.smk.futbol.model.Team

class MatchRepository private constructor() : BaseRepository<MatchDataSource>() {

    companion object {
        val instance by lazy { MatchRepository() }
    }

    suspend fun getPrevMatch(idLeague: String): MutableList<Match>? {
        return remoteDataStore?.getPrevMatch(idLeague)
    }

    suspend fun getNextMatch(idLeague: String): MutableList<Match>? {
        return remoteDataStore?.getNextMatch(idLeague)
    }

    suspend fun getSearchMatch(query: String): MutableList<Match>? {
        return remoteDataStore?.getSearchMatch(query)
    }

    suspend fun getDetailMatch(idEvent: String): MutableList<Match>? {
        return remoteDataStore?.getDetailMatch(idEvent)
    }

    suspend fun getDetailTeam(idTeam: String): MutableList<Team>? {
        return remoteDataStore?.getDetailTeam(idTeam)
    }

}