package com.smk.futbol.repository

import com.smk.futbol.data.EventEntity
import com.smk.futbol.datastore.event.EventRepositoryImpl

class EventRepository private constructor() : BaseRepository<EventRepositoryImpl>() {

    suspend fun getPrevMatch(idLeague: String): MutableList<EventEntity>? {
        return remoteDataStore?.getPrevMatch(idLeague)
    }

    companion object {
        val instance by lazy { EventRepository()}
    }
}