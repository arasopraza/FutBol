package com.smk.futbol.ui.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.repository.EventRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class MatchListViewModel(private val eventRepository: EventRepository) : ViewModel() {
    private val mViewState = MutableLiveData<MatchViewState>().apply {
        value = MatchViewState(loading = true)
    }
    val viewState: LiveData<MatchViewState>
    get() = mViewState

    init {
        getPrevMatch("")
    }

    fun getPrevMatch(leagueId: String) = viewModelScope.launch {
        try {
            val data = eventRepository.getPrevMatch(leagueId)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}