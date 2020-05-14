package com.smk.futbol.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.model.League
import com.smk.futbol.repository.LeagueRepository
import kotlinx.coroutines.launch

class LeagueDetailViewModel(private val leagueSets: LeagueRepository) : ViewModel() {
    private var mViewState = MutableLiveData<LeagueDetailViewState>().apply {
        value = LeagueDetailViewState(true, null, null)
    }
    val viewState: LiveData<LeagueDetailViewState>
        get() = mViewState

    fun setData(league: League) {
        mViewState.value = viewState.value?.copy(datadetail = league)
    }

    fun getDetailLeague(leagueId: String) = viewModelScope.launch {
        try {
            val data = leagueSets.getDetailLeague(leagueId)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}