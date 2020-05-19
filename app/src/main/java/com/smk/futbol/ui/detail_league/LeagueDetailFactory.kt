package com.smk.futbol.ui.detail

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.smk.futbol.repository.league.LeagueRepository


@Suppress("UNCHECKED_CAST")
class LeagueDetailFactory(
    savedStateRegistryOwner: SavedStateRegistryOwner, defaultArgs: Bundle,
    private val leagueRepository: LeagueRepository
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, defaultArgs) {

//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LeagueDetailViewModel::class.java))
//            return LeagueDetailViewModel(leagueRepository) as T
//        throw IllegalArgumentException()
//    }

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return LeagueDetailViewModel(leagueRepository) as T
    }
}