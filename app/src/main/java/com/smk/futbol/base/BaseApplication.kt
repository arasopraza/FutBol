package com.smk.futbol

import android.app.Application
import com.smk.futbol.data.repository.league.LeagueRepositoryImpl
import com.smk.futbol.network.WebClient
import com.smk.futbol.data.repository.event.EventRepository
import com.smk.futbol.data.repository.event.EventRepositoryImpl
import com.smk.futbol.data.repository.league.LeagueRepository
import com.smk.futbol.data.repository.event_detail.EventDetailRepository
import com.smk.futbol.data.repository.event_detail.EventDetailRepositoryImpl

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val webService = WebClient.WEB_SERVICE

        LeagueRepository.instance.apply {
            init(
                LeagueRepositoryImpl(webService)
            )
        }
        EventRepository.instance.apply {
            init(
                EventRepositoryImpl(webService)
            )
        }
        EventDetailRepository.instance.apply{
            init(
               EventDetailRepositoryImpl(webService)
            )
        }
    }
}