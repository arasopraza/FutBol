package com.smk.futbol.repository.event

import com.smk.futbol.data.Event
import com.smk.futbol.repository.BaseRepository

class EventRepository private constructor() : BaseRepository<EventRepositoryImpl>() {

    suspend fun getPrevMatch(idLeague: String): MutableList<Event>? {
        return remoteDataStore?.getPrevMatch(idLeague)
    }

    suspend fun getSearchMatch(query: String): MutableList<Event>? {
        return remoteDataStore?.getSearchEvent(query)
    }

    suspend fun getNextMatch(idLeague: String): MutableList<Event>? {
        return remoteDataStore?.getNextMatch(idLeague)
    }

    companion object {
        val instance by lazy { EventRepository() }
    }
}