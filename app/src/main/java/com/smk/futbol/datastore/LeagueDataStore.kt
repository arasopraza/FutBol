package com.smk.futbol.datastore

import com.smk.futbol.model.League

interface LeagueDataStore {
    suspend fun getDetailLeague(): MutableList<League>?
    suspend fun addAll(leagues: MutableList<League>)
}