package com.smk.futbol.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.repository.league.LeagueRepository
import kotlinx.coroutines.launch

class LeagueDetailViewModel(private val repository: LeagueRepository) : ViewModel() {
    private var mViewState = MutableLiveData<LeagueDetailViewState>().apply {
        value = LeagueDetailViewState(true)
    }
    val leagueObservable: LiveData<LeagueDetailViewState>
        get() = mViewState

//    init {
//        getDetailLeague("")
//    }


     fun getDetailLeague(idLeague: String) = viewModelScope.launch {
        try {
            val data = repository.getDetailLeague(idLeague)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}