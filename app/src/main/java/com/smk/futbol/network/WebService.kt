package com.smk.futbol.network

import com.smk.futbol.data.EventResponse
import com.smk.futbol.data.League
import com.smk.futbol.data.LeagueResponse
import com.smk.futbol.data.Match
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("eventspastleague.php?id")
    suspend fun getPrevMatch(
        @Query("id") idLeague: String
    ): EventResponse

    @GET("eventsnextleague.php?id")
    suspend fun getNextMatch(
        @Query("id") idLeague: String
    ): EventResponse

    @GET("lookupleague.php?id")
    suspend fun getDetailLeague(
        @Query("id") idLeague: String
    ): LeagueResponse

    @GET("lookupevent.php?id")
    fun getEventById(
        @Query("id") idEvent: String
    ): EventResponse

    @GET("searchevents.php?e")
    suspend fun getSearchEvent(
        @Query("e") Query: String
    ): Match
}