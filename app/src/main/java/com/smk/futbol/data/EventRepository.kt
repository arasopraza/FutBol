package com.smk.futbol.data.repository.event

import com.smk.futbol.data.source.Event
import com.smk.futbol.data.repository.BaseRepository

class EventRepository private constructor() : BaseRepository<EventRepositoryImpl>() {

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

    companion object {
        val instance by lazy { EventRepository() }
    }
}