package com.smk.futbol.ui.detailmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.data.MatchRepository

@Suppress("UNCHECKED_CAST")
class MatchDetailFactory(
    private val matchRepository: MatchRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchDetailViewModel::class.java))
            return MatchDetailViewModel(matchRepository) as T

        throw IllegalArgumentException()
    }
}
