package com.smk.futbol.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.repository.EventRepository
import java.lang.IllegalArgumentException

class MatchListFactory(private val eventRepository: EventRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchListViewModel::class.java))
            return MatchListViewModel(eventRepository) as T
        throw IllegalArgumentException()
    }

}