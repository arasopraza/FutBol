package com.smk.futbol.base

import android.app.Application
import com.smk.futbol.data.source.remote.LeagueRemoteDataSource
import com.smk.futbol.network.WebClient
import com.smk.futbol.data.EventRepository
import com.smk.futbol.data.source.remote.EventRemoteDataSource
import com.smk.futbol.data.LeagueRepository

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val webService = WebClient.WEB_SERVICE

        LeagueRepository.instance.apply {
            init(
                LeagueRemoteDataSource(
                    webService
                )
            )
        }
        EventRepository.instance.apply {
            init(
                EventRemoteDataSource(
                    webService
                )
            )
        }
    }
}