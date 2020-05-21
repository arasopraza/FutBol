package com.smk.futbol.ui.detail_league

import com.smk.futbol.data.League

data class LeagueDetailViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<League>? = null
)