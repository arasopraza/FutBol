package com.smk.futbol.data.source.remote.response

import com.smk.futbol.data.source.Event

data class EventResponse(
    val events: MutableList<Event>
)