package com.smk.futbol.utils

import com.smk.futbol.R
import com.smk.futbol.data.source.LeagueList

object LeagueDummy {

    private val leagueId = arrayOf(
        "4328",
        "4334",
        "4331",
        "4332",
        "4335",
        "4346",
        "4344",
        "4356",
        "4330",
        "4396"
    )

    private val leagueNames = arrayOf(
        "English Premier League",
        "French Ligue 1",
        "German Bundesliga",
        "Italian Seria A",
        "Spanish La Liga",
        "American Mayor League",
        "Protugeuese Premiera Liga",
        "Australian A League",
        "Scotish Premier League",
        "English League"
    )

    private val leagueBadge = intArrayOf(
        R.drawable.english_premier_league,
        R.drawable.french_ligue_1,
        R.drawable.german_bundesliga,
        R.drawable.italian_serie_a,
        R.drawable.spanish_la_liga,
        R.drawable.american_mayor_league,
        R.drawable.portugeuese_premiera_liga,
        R.drawable.australian_a_league,
        R.drawable.scotish_premier_league,
        R.drawable.english_league_1
    )

    val listData: ArrayList<LeagueList>
        get() {
            val list = arrayListOf<LeagueList>()
            for (position in leagueId.indices) {
                val leagueList = LeagueList("")
                leagueList.id = leagueId[position]
                leagueList.name = leagueNames[position]
                leagueList.image = leagueBadge[position]
                list.add(leagueList)
            }

            return list
        }
}