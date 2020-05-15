package com.smk.futbol.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.repository.LeagueRepository
import com.smk.futbol.repository.MatchRepository
import java.lang.IllegalArgumentException

class MatchListFactory(private val matchRepository: MatchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchListViewModel::class.java))
            return MatchListViewModel(matchRepository) as T
        throw IllegalArgumentException()
    }

}