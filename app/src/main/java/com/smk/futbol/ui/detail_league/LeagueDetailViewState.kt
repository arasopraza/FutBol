package com.smk.futbol.ui.detail

import com.smk.futbol.data.LeagueEntity

data class LeagueDetailViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<LeagueEntity>? = null
)