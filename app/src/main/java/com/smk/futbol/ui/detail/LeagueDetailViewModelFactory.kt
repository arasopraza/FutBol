package com.smk.futbol.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.repository.LeagueRepository



@Suppress("UNCHECKED_CAST")
class LeagueDetailViewModelFactory(
    private val leagueRepository: LeagueRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueDetailViewModel::class.java))
            return LeagueDetailViewModel() as T
        throw IllegalArgumentException()
    }
}