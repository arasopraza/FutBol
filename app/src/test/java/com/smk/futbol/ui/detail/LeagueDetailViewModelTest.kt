package com.smk.futbol.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.smk.futbol.model.League
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class LeagueDetailViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    var leagueDetailViewModel: LeagueDetailViewModel? = null

    @Before
    fun init() {
        leagueDetailViewModel = LeagueDetailViewModel()
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun shouldNullWhenFirstInitialized() {
        val state = leagueDetailViewModel!!.viewState.value!!
        assertNull(state.data)
    }

    @Test
    fun shouldNotNullAfterSetData() {
        leagueDetailViewModel?.setData(League("", "", "", "", ""))
        val state = leagueDetailViewModel!!.viewState.value!!
        assertNotNull(state.data)
    }
}