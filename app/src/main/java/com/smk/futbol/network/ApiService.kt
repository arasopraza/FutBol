package com.smk.futbol.network

import com.smk.futbol.model.Event
import com.smk.futbol.model.League
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("eventspastleague.php?id")
    suspend fun getPrevMatch(
        @Query("id") idLeague: String
    ): Event.EventResponse

//    @GET("eventsnextleague.php")
//    suspend fun getNextMatch(
//        @Query("id") idLeague: String
//    ): Response<Event.EventResponse>

    @GET("lookupleague.php?id")
    suspend fun getDetailLeague(
        @Query("id") idLeague: String
    ): League.LeagueResponse

//    @GET("lookupevent.php?{id}")
//    fun getEventById(
//        @Path("id") id: String
//    ): Response<Event>
}