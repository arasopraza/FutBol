package com.smk.futbol.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.data.MatchRepository

@Suppress("UNCHECKED_CAST")
class SearchFactory(
    private val matchRepository: MatchRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java))
            return SearchViewModel(matchRepository) as T

        throw IllegalArgumentException()
    }
}