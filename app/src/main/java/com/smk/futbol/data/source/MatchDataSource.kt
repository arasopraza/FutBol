package com.smk.futbol.data.source

import com.smk.futbol.model.Match
import com.smk.futbol.model.Team

interface MatchDataSource {
    suspend fun getPrevMatch(idLeague: String): MutableList<Match>?
    suspend fun getNextMatch(idLeague: String): MutableList<Match>?
    suspend fun getSearchMatch(query: String): MutableList<Match>?
    suspend fun getDetailMatch(idMatch: String): MutableList<Match>?
    suspend fun getDetailTeam(idTeam: String): MutableList<Team>?
}