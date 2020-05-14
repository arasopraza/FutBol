package com.smk.futbol.ui.detail

import com.smk.futbol.model.League
import java.lang.Exception

data class LeagueDetailViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<League>? = null,
    val datadetail: League? = null
)