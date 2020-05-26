package com.smk.futbol.data.source.remote.response

import com.smk.futbol.data.source.League

data class LeagueResponse(
    val leagues: MutableList<League>
)