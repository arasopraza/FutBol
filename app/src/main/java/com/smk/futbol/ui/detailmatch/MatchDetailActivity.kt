package com.smk.futbol.ui.detailmatch

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.smk.futbol.R
import com.smk.futbol.data.MatchRepository
import com.smk.futbol.model.Match
import com.smk.futbol.model.Favorite
import com.smk.futbol.model.Team
import com.smk.futbol.data.source.local.database
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.text.SimpleDateFormat

@Suppress(
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class MatchDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: MatchDetailViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    private lateinit var events: Match
    private lateinit var eventId: String
    private var isFavorite = false
    private var menuItem: Menu? = null

    companion object {
        const val EVENT_DETAIL = "event_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        eventId = intent.getStringExtra("EVENT_DETAIL")
        supportActionBar?.title = getString(R.string.detail_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initObservable()
        showLoading(true)
        favoriteState()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menuItem = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true
            }
            R.id.add_favorite -> {
                if (isFavorite) removeFromFavorite() else addFavorite()

                isFavorite = !isFavorite
                setFavorite()
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }

    private fun initObservable() {
        val id = intent.getStringExtra("EVENT_DETAIL")
        viewModelFactory = ViewModelProvider(
            this, MatchDetailFactory
                (MatchRepository.instance)
        )
        viewModel = viewModelFactory[MatchDetailViewModel::class.java].apply {
            matchObservable.observe(
                this@MatchDetailActivity,
                Observer(this@MatchDetailActivity::handleState)
            )
            setEventDetail(id)
        }
    }

    private fun handleState(viewState: MatchDetailViewState?) {
        if (!viewState?.loading!!) {
            showLoading(false)
        }
        viewState.data?.let { showEventDetail(it) }
        viewState.teamHome?.let { showHomeTeamDetail(it) }
        viewState.teamAway?.let { showAwayTeamDetail(it) }
    }

    @SuppressLint("SimpleDateFormat")
    private fun showEventDetail(data: MutableList<Match>) {
        events = Match(
            data[0].sport,
            data[0].dateEvent,
            data[0].idAwayTeam,
            data[0].idEvent,
            data[0].idHomeTeam,
            data[0].idLeague,
            data[0].intAwayScore,
            data[0].intAwayShots,
            data[0].intHomeScore,
            data[0].intHomeShots,
            data[0].strAwayRedCards,
            data[0].strAwayTeam,
            data[0].strAwayYellowCards,
            data[0].strDate,
            data[0].strEvent,
            data[0].strHomeRedCards,
            data[0].strHomeTeam,
            data[0].strHomeYellowCards,
            data[0].strLeague
        )

        viewModel.setHomeTeamDetail(data[0].idHomeTeam)
        viewModel.setAwayTeamDetail(data[0].idAwayTeam)

        name_league.text = data[0].strLeague
        name_event.text = data[0].strEvent
        home_name.text = data[0].strHomeTeam
        home_score.text = data[0].intHomeScore
        home_yellow_cards.text = data[0].strHomeYellowCards

        if (data[0].intHomeShots.toString().trim() == "null") {
            home_shots.text = "-"
        } else {
            home_shots.text = data[0].intHomeShots
        }

        if (data[0].strHomeRedCards == "null") {
            home_red_cards.text = "-"
        } else {
            home_red_cards.text = data[0].strHomeRedCards
        }

        away_name.text = data[0].strAwayTeam
        away_score.text = data[0].intAwayScore
        away_yellow_cards.text = data[0].strAwayYellowCards

        if (data[0].intAwayShots.toString().trim() == "null") {
            away_shots.text = "-"
        } else {
            away_shots.text = data[0].intAwayShots
        }

        if (data[0].strAwayRedCards == "null") {
            away_red_cards.text = data[0].strAwayRedCards
        } else {
            away_red_cards.text = data[0].strAwayRedCards
        }

        val parser = SimpleDateFormat("yyyy-mm-dd")
        val formatter = SimpleDateFormat("EEE, dd, mm, yyyy")
        val date: String = formatter.format(parser.parse(data[0].dateEvent))
        date_event.text = date
    }

    private fun showHomeTeamDetail(data: MutableList<Team>) {
        Glide.with(this)
            .load(data[0].strTeamBadge)
            .into(home_image)
    }

    private fun showAwayTeamDetail(data: MutableList<Team>) {
        Glide.with(this)
            .load(data[0].strTeamBadge)
            .into(away_image)
    }

    private fun favoriteState() {
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs(
                    "(EVENT_ID = {id})",
                    "id" to eventId
                )
            val favorite = result.parseList(classParser<Favorite>())
            if (favorite.isNotEmpty()) isFavorite = true
        }
    }

    private fun addFavorite() {
        try {
            database.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.EVENT_ID to events.idEvent,
                    Favorite.HOME_NAME to events.strHomeTeam,
                    Favorite.AWAY_NAME to events.strAwayTeam,
                    Favorite.HOME_SCORE to events.intHomeScore,
                    Favorite.AWAY_SCORE to events.intAwayScore
                )
            }
            Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(
                    Favorite.TABLE_FAVORITE, "(EVENT_ID = {id})",
                    "id" to eventId
                )
            }
            Toast.makeText(this, "Removed from favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_star_black_24dp)
        else
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_star_border_black_24dp)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            loading_detail_event.visibility = View.VISIBLE
        } else
            loading_detail_event.visibility = View.GONE
    }
}

