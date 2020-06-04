package com.smk.futbol.ui.match.previous

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.data.MatchRepository

@Suppress("UNCHECKED_CAST")
class MatchPrevFactory(
    private val matchRepository: MatchRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchPrevViewModel::class.java))
            return MatchPrevViewModel(matchRepository) as T

        throw IllegalArgumentException()
    }
}