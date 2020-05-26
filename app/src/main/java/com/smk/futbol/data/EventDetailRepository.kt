package com.smk.futbol.data

import com.smk.futbol.base.BaseRepository
import com.smk.futbol.data.source.remote.EventDetailRemoteDataSource
import com.smk.futbol.data.source.Team

class EventDetailRepository private constructor() : BaseRepository<EventDetailRemoteDataSource>() {

//    suspend fun getBadgeTeamHome(idTeam: String): MutableList<Team>? {
//        return remoteDataStore?.getBadgeTeamHome(idTeam)
//    }

    companion object {
        val instance by lazy { EventDetailRepository() }
    }
}