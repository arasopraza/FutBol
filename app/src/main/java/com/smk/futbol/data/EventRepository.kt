package com.smk.futbol.data

import com.smk.futbol.base.BaseRepository
import com.smk.futbol.data.source.Event
import com.smk.futbol.data.source.Team
import com.smk.futbol.data.source.remote.EventRemoteDataSource

class EventRepository private constructor() : BaseRepository<EventRemoteDataSource>() {

    suspend fun getPrevMatch(idLeague: String): MutableList<Event>? {
        return remoteDataStore?.getPrevMatch(idLeague)
    }

    suspend fun getNextMatch(idLeague: String): MutableList<Event>? {
        return remoteDataStore?.getNextMatch(idLeague)
    }

    suspend fun getSearchMatch(query: String): MutableList<Event>? {
        return remoteDataStore?.getSearchEvent(query)
    }

    suspend fun getDetailEvent(idEvent: String): MutableList<Event>? {
        return remoteDataStore?.getDetailEvent(idEvent)
    }

    suspend fun getTeamDetail(idTeam: String): MutableList<Team>? {
        return remoteDataStore?.getBadgeTeam(idTeam)
    }

    companion object {
        val instance by lazy { EventRepository() }
    }
}