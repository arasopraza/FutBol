package com.smk.futbol.data.source

import com.smk.futbol.model.League

interface LeagueDataSource {
    suspend fun getDetailLeague(idLeague: String): MutableList<League>?
}