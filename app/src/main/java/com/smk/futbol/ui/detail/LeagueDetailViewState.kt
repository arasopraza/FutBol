package com.smk.futbol.ui.detail

import com.smk.futbol.model.League

data class LeagueDetailViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<League>? = null
)