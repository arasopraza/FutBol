package com.smk.futbol.ui.detail_event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.smk.futbol.R
import com.smk.futbol.data.EventRepository
import com.smk.futbol.data.source.Event
import kotlinx.android.synthetic.main.activity_detail_match.*

@Suppress(
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class EventDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: EventDetailViewModel
    private lateinit var viewModelFactory: ViewModelProvider

    companion object {
        const val EVENT_DETAIL = "event_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        supportActionBar?.title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        initObservable()
    }

    private fun initObservable() {
        val id = intent.getParcelableExtra<Event>(EVENT_DETAIL)
        viewModelFactory = ViewModelProvider(
            this, EventDetailFactory
                (this, Bundle(), EventRepository.instance)
        )
        viewModel = viewModelFactory[EventDetailViewModel::class.java].apply {
            eventObservable.observe(
                this@EventDetailActivity,
                Observer(this@EventDetailActivity::handleState)
            )
            setDetailEvent(id.idEvent)
        }
    }

    private fun handleState(viewState: EventDetailViewState?) {
        viewState?.data?.let { showDetail(it) }
    }

    private fun showDetail(events: MutableList<Event>) {
        name_league.text = events[0].strLeague
        name_event.text = events[0].strEvent
        date_event.text = events[0].dateEvent
        name_home.text = events[0].strHomeTeam
        name_away.text = events[0].strAwayTeam
        score_home.text = events[0].intHomeScore
        score_away.text = events[0].intAwayScore
        Glide.with(this)
            .load(viewModel.setTeamBadge(events[0].idHomeTeam))
            .into(image_home)
        Glide.with(this)
            .load(viewModel.setTeamBadge(events[0].idAwayTeam))
            .into(image_away)
    }

//    private fun showHomeBadge(team: MutableList<Team>) {
//        Glide.with(this)
//            .load(team[0].strTeamBadge)
//            .into(image_home)
//    }
}

