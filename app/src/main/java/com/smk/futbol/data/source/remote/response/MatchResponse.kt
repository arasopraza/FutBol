package com.smk.futbol.data.source.remote.response

import com.smk.futbol.data.source.Event


data class MatchResponse(
    val event: MutableList<Event>
)