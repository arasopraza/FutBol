package com.smk.futbol.repository

import com.smk.futbol.datastore.event.EventRemoteDataStore
import com.smk.futbol.model.Event

class EventRepository private constructor() : BaseRepository<EventRemoteDataStore>() {

    suspend fun getPrevMatch(idLeague: String): MutableList<Event>? {
        return remoteDataStore?.getPrevMatch(idLeague)
    }

    companion object {
        val instance by lazy { EventRepository() }
    }
}