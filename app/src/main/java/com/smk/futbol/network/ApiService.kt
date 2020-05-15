package com.smk.futbol.network

import com.smk.futbol.model.Event
import com.smk.futbol.model.League
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("eventspastleague.php")
    suspend fun getPrevMatch(
        @Query("id") leagueId: String
    ): Response<Event.EventResponse>

    @GET("eventsnextleague.php")
    suspend fun getNextMatch(
        @Query("id") idLeague: String
    ): Response<Event.EventResponse>

    @GET("1/lookupleague.php?id=4346")
    suspend fun getDetailLeague(
    ): League.LeagueResponse

    @GET("lookupevent.php")
    fun getEventById(
        @Path("id") id: String
    ): Response<Event>
}