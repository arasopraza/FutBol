package com.smk.futbol.ui.detailleague

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.data.LeagueRepository

@Suppress("UNCHECKED_CAST")
class LeagueDetailFactory(
    private val leagueRepository: LeagueRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueDetailViewModel::class.java))
            return LeagueDetailViewModel(leagueRepository) as T

        throw IllegalArgumentException()
    }
}