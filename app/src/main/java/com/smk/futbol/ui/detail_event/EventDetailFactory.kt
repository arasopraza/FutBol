package com.smk.futbol.ui.detail_event

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.smk.futbol.data.EventRepository

@Suppress("UNCHECKED_CAST")
class EventDetailFactory(
    savedStateRegistryOwner: SavedStateRegistryOwner, defaultArgs: Bundle,
    private val eventRepository: EventRepository
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return EventDetailViewModel(eventRepository) as T
    }
}
