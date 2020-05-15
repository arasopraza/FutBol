package com.smk.futbol.datastore

import com.smk.futbol.model.Event
import com.smk.futbol.model.League

interface LeagueDataStore {
    suspend fun getDetailLeague(leagueId: String): MutableList<League>?
    suspend fun addAll(leagues: MutableList<League>?)
}