package com.smk.futbol.datastore.league

import com.smk.futbol.model.League
import com.smk.futbol.network.ApiService

class LeagueRemoteDataStore(private val apiService: ApiService) :
    LeagueDataStore {
    override suspend fun getDetailLeague(): MutableList<League>? {
        val response = apiService.getDetailLeague()
        if (response != null ) return response.leagues

        throw Exception("Terjadi kesalahan ${response}")
    }

    override suspend fun addAll(leagues: MutableList<League>) {
    }

}