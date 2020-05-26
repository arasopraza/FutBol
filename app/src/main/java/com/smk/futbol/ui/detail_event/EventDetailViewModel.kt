package com.smk.futbol.ui.detail_event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.data.EventRepository
import kotlinx.coroutines.launch

class EventDetailViewModel(private val repository: EventRepository) : ViewModel() {
    private var mViewState = MutableLiveData<EventDetailViewState>().apply {
        value = EventDetailViewState(true)
    }

    val eventObservable: LiveData<EventDetailViewState>
        get() = mViewState

    fun setDetailEvent(idEvent: String) = viewModelScope.launch {
        try {
            val data = repository.getDetailEvent(idEvent)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }

    fun setTeamBadge(idTeam: String) = viewModelScope.launch {
        try {
            val team = repository.getBadgeTeam(idTeam)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, team = team)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, team = null)
        }
    }
}