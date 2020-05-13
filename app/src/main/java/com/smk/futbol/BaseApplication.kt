package com.smk.futbol

import android.app.Application
import com.smk.futbol.datastore.LeagueRemoteDataStore
import com.smk.futbol.network.ApiClient
import com.smk.futbol.repository.LeagueRepository

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val apiService = ApiClient.API_SERVICE
        LeagueRepository.instance.apply {
            init(
                LeagueRemoteDataStore(apiService)
            )
        }
    }
}