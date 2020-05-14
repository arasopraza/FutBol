package com.smk.futbol.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smk.futbol.model.League
import com.smk.futbol.repository.LeagueRepository

class LeagueDetailViewModel : ViewModel() {
    private var mViewState = MutableLiveData<LeagueDetailViewState>().apply {
        value = LeagueDetailViewState(true, null, null)
    }
    val viewState: LiveData<LeagueDetailViewState>
        get() = mViewState

    fun setData(league: League) {
        mViewState.value = viewState.value?.copy(datadetail = league)
    }
}