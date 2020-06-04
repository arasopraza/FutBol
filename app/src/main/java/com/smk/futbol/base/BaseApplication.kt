package com.smk.futbol.base

import android.app.Application
import com.smk.futbol.data.MatchRepository
import com.smk.futbol.data.LeagueRepository
import com.smk.futbol.data.source.remote.MatchRemoteDataSource
import com.smk.futbol.data.source.remote.LeagueRemoteDataSource
import com.smk.futbol.network.WebClient

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val webService = WebClient.WEB_SERVICE

        LeagueRepository.instance.apply {
            init(
                LeagueRemoteDataSource(webService)
            )
        }

        MatchRepository.instance.apply {
            init(
                MatchRemoteDataSource(webService)
            )
        }
    }
}