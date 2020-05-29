package com.smk.futbol.ui.detail_event

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.smk.futbol.R
import com.smk.futbol.data.EventRepository
import com.smk.futbol.data.source.Event
import com.smk.futbol.data.source.Team
import kotlinx.android.synthetic.main.activity_detail_match.*
import java.text.SimpleDateFormat

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

        initObservable()
        initHomeTeam()
        initAwayTeam()
        showLoading(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
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
            setEventDetail(id.idEvent)
        }
    }

    private fun initHomeTeam() {
        val id = intent.getParcelableExtra<Event>(EVENT_DETAIL)
        viewModel = viewModelFactory[EventDetailViewModel::class.java].apply {
            eventObservable.observe(
                this@EventDetailActivity,
                Observer(this@EventDetailActivity::handleState)
            )
            viewModel.setHomeTeamDetail(id.idHomeTeam)
        }
    }

    private fun initAwayTeam() {
        val id = intent.getParcelableExtra<Event>(EVENT_DETAIL)
        viewModel = viewModelFactory[EventDetailViewModel::class.java].apply {
            eventObservable.observe(
                this@EventDetailActivity,
                Observer(this@EventDetailActivity::handleState)
            )
            viewModel.setAwayTeamDetail(id.idAwayTeam)
        }
    }


    private fun handleState(viewState: EventDetailViewState?) {
        if (!viewState?.loading!!) {
            showLoading(false)
        }
        viewState.data?.let { showEventDetail(it) }
        viewState.teamHome?.let { showHomeTeamDetail(it) }
        viewState.teamAway?.let { showAwayTeamDetail(it) }
    }

    @SuppressLint("SimpleDateFormat")
    private fun showEventDetail(events: MutableList<Event>) {
        name_league.text = events[0].strLeague
        name_event.text = events[0].strEvent
        home_name.text = events[0].strHomeTeam
        home_score.text = events[0].intHomeScore
        home_shots.text = events[0].intHomeShots
        home_yellow_cards.text = events[0].strHomeYellowCards
        home_red_cards.text = events[0].strHomeRedCards
        away_name.text = events[0].strAwayTeam
        away_score.text = events[0].intAwayScore
        away_shots.text = events[0].intAwayShots
        away_yellow_cards.text = events[0].strAwayYellowCards
        away_red_cards.text = events[0].strAwayRedCards

        val parser = SimpleDateFormat("yyyy-mm-dd")
        val formatter = SimpleDateFormat("EEE, dd, mm, yyyy")
        val date: String = formatter.format(parser.parse(events[0].dateEvent))
        date_event.text = date
    }

    private fun showHomeTeamDetail(teams: MutableList<Team>) {
        home_manager.text = teams[0].strManager
        Glide.with(this)
            .load(teams[0].strTeamBadge)
            .into(home_image)
    }

    private fun showAwayTeamDetail(teams: MutableList<Team>) {
        away_manager.text = teams[0].strManager
        Glide.with(this)
            .load(teams[0].strTeamBadge)
            .into(away_image)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            loading_detail_event.visibility = View.VISIBLE
        } else
            loading_detail_event.visibility = View.GONE
    }
}

