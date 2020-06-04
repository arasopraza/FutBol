package com.smk.futbol.ui.match.next

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.data.MatchRepository

@Suppress("UNCHECKED_CAST")
class MatchNextFactory(
    private val matchRepository: MatchRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchNextViewModel::class.java))
            return MatchNextViewModel(matchRepository) as T

        throw IllegalArgumentException()
    }
}