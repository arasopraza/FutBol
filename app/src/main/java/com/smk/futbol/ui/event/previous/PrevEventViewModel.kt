package com.smk.futbol.ui.event.previous

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.data.EventRepository
import com.smk.futbol.ui.event.EventViewState
import kotlinx.coroutines.launch
import java.lang.Exception

class PrevEventViewModel(private val repository: EventRepository) : ViewModel() {
    private var mViewState = MutableLiveData<EventViewState>().apply {
        value = EventViewState(true)
    }
    val eventObservable: LiveData<EventViewState>
        get() = mViewState

    fun setPrevMatch(idLeague: String) = viewModelScope.launch {
        try {
            val data = repository.getPrevMatch(idLeague)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}