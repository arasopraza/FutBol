package com.smk.futbol.network

import com.smk.futbol.model.Event
import com.smk.futbol.model.League
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lookupleague.php")
    fun getDetailLeague(): Response<League.LeagueResponse>

    @GET("lookupevent.php")
    fun getEventById(
        @Query("id") id: String
    ): Response<Event>
}