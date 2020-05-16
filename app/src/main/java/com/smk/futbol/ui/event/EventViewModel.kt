package com.smk.futbol.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.repository.EventRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class EventViewModel(private val eventRepository: EventRepository) : ViewModel() {
    private var mViewState = MutableLiveData<EventViewState>().apply {
        value = EventViewState(true)
    }
    val eventObservable: LiveData<EventViewState>
        get() = mViewState

//    init {
//        getPrevMatch("")
//    }

    fun getPrevMatch(idLeague: String) = viewModelScope.launch {
        try {
            val data = eventRepository.getPrevMatch(idLeague)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}