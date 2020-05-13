package com.smk.futbol.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smk.futbol.model.Leaguee

class LeagueDetailViewModel : ViewModel() {
    private var mViewState = MutableLiveData<LeagueDetailViewState>().apply {
        value = LeagueDetailViewState(null)
    }
    val viewState: LiveData<LeagueDetailViewState>
        get() = mViewState

    fun setData(league: Leaguee) {
        mViewState.value = viewState.value?.copy(data = league)
    }
}