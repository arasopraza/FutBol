package com.smk.futbol.ui.detailmatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.data.MatchRepository
import kotlinx.coroutines.launch

class MatchDetailViewModel(private val repository: MatchRepository) : ViewModel() {
    private var mViewState = MutableLiveData<MatchDetailViewState>().apply {
        value = MatchDetailViewState(true)
    }

    val matchObservable: LiveData<MatchDetailViewState>
        get() = mViewState

    fun setEventDetail(idEvent: String) = viewModelScope.launch {
        try {
            val data = repository.getDetailMatch(idEvent)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }

    fun setHomeTeamDetail(idTeam: String) = viewModelScope.launch {
        try {
            val team = repository.getDetailTeam(idTeam)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, teamHome = team)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, teamHome = null)
        }

    }

    fun setAwayTeamDetail(idTeam: String) = viewModelScope.launch {
        try {
            val team = repository.getDetailTeam(idTeam)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, teamAway = team)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, teamAway = null)
        }
    }
}