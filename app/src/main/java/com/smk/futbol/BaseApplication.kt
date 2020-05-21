package com.smk.futbol

import android.app.Application
import com.smk.futbol.repository.event.EventRepositoryImpl
import com.smk.futbol.repository.league.LeagueRepositoryImpl
import com.smk.futbol.network.ApiClient
import com.smk.futbol.repository.event.EventRepository
import com.smk.futbol.repository.league.LeagueRepository

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val apiService = ApiClient.API_SERVICE

        LeagueRepository.instance.apply {
            init(
                LeagueRepositoryImpl(apiService)
            )
        }
        EventRepository.instance.apply {
            init(
                EventRepositoryImpl(apiService)
            )
        }
    }
}