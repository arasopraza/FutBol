package com.smk.futbol.data.source.remote.response

import com.smk.futbol.model.League

data class LeagueResponse(
    val leagues: MutableList<League>
)