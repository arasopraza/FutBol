package com.smk.futbol.ui.match

import com.smk.futbol.model.Match

data class MatchViewState(
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<Match>? = null
)
