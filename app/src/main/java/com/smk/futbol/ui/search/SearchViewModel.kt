package com.smk.futbol.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smk.futbol.repository.event.EventRepository
import com.smk.futbol.ui.event.EventViewState
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: EventRepository) : ViewModel(){

private var mViewState = MutableLiveData<EventViewState>().apply {
    value = EventViewState(true)
}

val searchObservable: LiveData<EventViewState>
    get() = mViewState

fun setSearchMatch(query: String) = viewModelScope.launch {
    try {
        val data = repository.getSearchMatch(query)
        mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
    } catch (ex: Exception) {
        mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
    }
}
}