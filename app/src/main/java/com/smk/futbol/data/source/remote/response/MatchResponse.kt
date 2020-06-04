package com.smk.futbol.data.source.remote.response

import com.smk.futbol.model.Match


data class MatchResponse(
    val event: MutableList<Match>
)