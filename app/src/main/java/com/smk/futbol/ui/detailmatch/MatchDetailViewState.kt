package com.smk.futbol.ui.detailmatch

import com.smk.futbol.model.Match
import com.smk.futbol.model.Team

data class MatchDetailViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<Match>? = null,
    val teamHome: MutableList<Team>? = null,
    val teamAway: MutableList<Team>? = null
)