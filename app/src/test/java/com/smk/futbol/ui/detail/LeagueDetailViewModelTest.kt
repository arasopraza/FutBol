package com.smk.futbol.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.smk.futbol.model.League
import com.smk.futbol.repository.LeagueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LeagueDetailViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    var leagueRepository: LeagueRepository? = null

    var leagueDetailViewModel: LeagueDetailViewModel? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        leagueDetailViewModel = LeagueDetailViewModel(leagueRepository!!)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun shouldNullWhenFirstInitialized() {
        val state = leagueDetailViewModel!!.viewState.value!!
        assertNull(state.data)
    }

    @Test
    fun shouldNotNullAfterSetData() {
        leagueDetailViewModel?.setData(League("", "", ""))
        val state = leagueDetailViewModel!!.viewState.value!!
        assertNotNull(state.datadetail)
    }
}