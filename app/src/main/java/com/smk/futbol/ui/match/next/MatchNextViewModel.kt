package com.smk.futbol.ui.match.next

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.data.MatchRepository
import com.smk.futbol.ui.match.MatchViewState
import kotlinx.coroutines.launch
import java.lang.Exception

class MatchNextViewModel(private val repository: MatchRepository) : ViewModel() {
    private var mViewState = MutableLiveData<MatchViewState>().apply {
        value = MatchViewState(true)
    }

    val matchObservable: LiveData<MatchViewState>
    get() = mViewState

    fun setNextMatch(idLeague: String) = viewModelScope.launch {
        try {
            val data = repository.getNextMatch(idLeague)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}
