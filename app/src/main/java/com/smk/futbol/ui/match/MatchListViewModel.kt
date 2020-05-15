package com.smk.futbol.ui.match

import android.util.EventLog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.repository.MatchRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class MatchListViewModel(private val matchRepository: MatchRepository) : ViewModel() {
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
            val data = matchRepository.getPrevMatch(leagueId)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}