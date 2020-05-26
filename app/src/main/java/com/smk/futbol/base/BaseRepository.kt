package com.smk.futbol.base



abstract class BaseRepository<DataStore> {
    protected var remoteDataStore: DataStore? = null

    fun init(remoteDataStore: DataStore){
        this.remoteDataStore = remoteDataStore
    }
}