package com.smk.futbol.ui.detail_event

import com.smk.futbol.data.source.Event
import com.smk.futbol.data.source.Team

data class EventDetailViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<Event>? = null,
    val teamHome: MutableList<Team>? = null,
    val teamAway: MutableList<Team>? = null
)