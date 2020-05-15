package com.smk.futbol.datastore.match

import com.smk.futbol.model.Event

interface MatchDataStore {
    suspend fun getPrevMatch(leagueId: String): MutableList<Event>?
    suspend fun addAll(leagues: MutableList<Event>?)
}