package com.smk.futbol.repository

import com.smk.futbol.datastore.league.LeagueDataStore
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LeagueRepositoryTest {
    @Mock
    var remoteDataStore: LeagueDataStore? = null
    var leagueDataStore: LeagueDataStore? = null
    var leagueRepository: LeagueRepository? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        leagueRepository = LeagueRepository.instance.apply {
            init(remoteDataStore!!, leagueDataStore!!)
        }
    }

    @Test
    fun shouldThrowExceptionWhenRemoteThrowException() {
        runBlocking {
            `when`(remoteDataStore?.getDetailLeague()).thenReturn(null)
            try {
                leagueRepository?.getDetailLeague()
            } catch (ex: Exception) {

            }
        }
    }
}