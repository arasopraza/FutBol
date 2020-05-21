package com.smk.futbol.ui.detail_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smk.futbol.R
import com.smk.futbol.data.Event
import kotlinx.android.synthetic.main.activity_detail_match.*

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        showDetail()
    }

    private fun showDetail() {
        val event = intent.getParcelableExtra(EVENT_DETAIL) as Event
        name_league.text = event.strLeague
        name_season.text = event.intRound
        date_event.text = event.dateEvent
        name_home.text = event.strHomeTeam
        name_away.text = event.strAwayTeam
        score_home.text = event.intHomeScore
        score_away.text = event.intAwayScore
    }

    companion object {
        const val EVENT_DETAIL = "event_detail"
    }
}
