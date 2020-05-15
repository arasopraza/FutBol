package com.smk.futbol

import android.app.Application
import com.smk.futbol.datastore.league.LeagueRemoteDataStore
import com.smk.futbol.datastore.match.MatchRemoteDataStore
import com.smk.futbol.network.ApiClient
import com.smk.futbol.repository.LeagueRepository
import com.smk.futbol.repository.MatchRepository

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val apiService = ApiClient.API_SERVICE
        LeagueRepository.instance.apply {
            init(null,
                LeagueRemoteDataStore(apiService)
            )
        }
//        MatchRepository.instance.apply {
//            init(
//                MatchRemoteDataStore(apiService)
//            )
//        }
    }
}