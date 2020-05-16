package com.smk.futbol.ui.event

import com.smk.futbol.model.Event

data class EventViewState(
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<Event>? = null
)
