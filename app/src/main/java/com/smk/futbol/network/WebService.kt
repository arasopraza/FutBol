package com.smk.futbol.network

import com.smk.futbol.data.source.remote.response.EventResponse
import com.smk.futbol.data.source.remote.response.MatchResponse
import com.smk.futbol.data.source.remote.response.LeagueResponse
import com.smk.futbol.data.source.remote.response.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("eventspastleague.php?id")
    suspend fun getPrevMatch(
        @Query("id") idLeague: String
    ): Response <EventResponse>

    @GET("eventsnextleague.php?id")
    suspend fun getNextMatch(
        @Query("id") idLeague: String
    ): Response <EventResponse>

    @GET("lookupleague.php?id")
    suspend fun getDetailLeague(
        @Query("id") idLeague: String
    ): Response <LeagueResponse>

    @GET("lookupevent.php?id")
    suspend fun getDetailMatch(
        @Query("id") idEvent: String
    ): Response <EventResponse>

    @GET("lookupteam.php?id")
    suspend fun getDetailTeam(
        @Query("id") idTeam: String
    ): Response <TeamResponse>

    @GET("searchevents.php?e")
    suspend fun getSearchMatch(
        @Query("e") Query: String
    ): Response <MatchResponse>
}