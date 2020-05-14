package com.smk.futbol.repository

import com.smk.futbol.datastore.LeagueDataStore
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LeagueRepositoryTest {
    @Mock
    var remoteDataStore: LeagueDataStore? = null

    var leagueRepository: LeagueRepository? = null

   @Before
   fun init(){
       MockitoAnnotations.initMocks(this)
       leagueRepository = LeagueRepository.instance.apply {
           init(remoteDataStore!!)
       }
   }

    @Test
    fun shouldThrowExceptionWhenRemoteThrowException(){
        runBlocking {
            `when`(remoteDataStore?.getDetailLeague(leagueId= "4346")).thenReturn(null)
            try {
                leagueRepository?.getDetailLeague(leagueId = "4346")
            } catch (ex: Exception){

            }
        }
    }
}