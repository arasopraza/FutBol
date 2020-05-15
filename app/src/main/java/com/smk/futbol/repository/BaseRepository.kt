package com.smk.futbol.repository

import com.smk.futbol.datastore.league.LeagueDataStore

abstract class BaseRepository<DataStore> {
    protected var leagueDataStore: DataStore? = null
    protected var remoteDataStore: DataStore? = null

    fun init(leagueDataStore: DataStore?, remoteDataStore: DataStore){
        this.remoteDataStore = remoteDataStore
        this.leagueDataStore = leagueDataStore
    }
}