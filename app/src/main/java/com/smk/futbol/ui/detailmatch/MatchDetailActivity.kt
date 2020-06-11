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
    private lateinit var match: Match
    private lateinit var matchId: String
    private var isFavorite = false
    private var menuItem: Menu? = null

    companion object {
        const val EVENT_DETAIL = "event_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        matchId = intent.getStringExtra("EVENT_DETAIL")
        supportActionBar?.title = getString(R.string.detail_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initObservable()
        showLoading(true)
        favoriteState()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        this.menuItem = menu
        setFavorite()
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
        viewState.data?.let { showMatchDetail(it) }
        viewState.teamHome?.let { showHomeTeamDetail(it) }
        viewState.teamAway?.let { showAwayTeamDetail(it) }
    }

    @SuppressLint("SimpleDateFormat")
    private fun showMatchDetail(data: MutableList<Match>) {
        match = Match(
            data[0].sport,
            data[0].matchDate,
            data[0].awayId,
            data[0].matchId,
            data[0].homeId,
            data[0].leagueId,
            data[0].awayScore,
            data[0].awayShots,
            data[0].homeScore,
            data[0].homeShots,
            data[0].awayRedCards,
            data[0].awayTeam,
            data[0].awayYellowCards,
            data[0].date,
            data[0].matchName,
            data[0].homeRedCards,
            data[0].homeTeam,
            data[0].homeYellowCards,
            data[0].leagueName
        )

        viewModel.setHomeTeamDetail(data[0].homeId)
        viewModel.setAwayTeamDetail(data[0].awayId)

        name_league.text = data[0].leagueName
        name_event.text = data[0].matchName
        home_name.text = data[0].homeTeam
        home_score.text = data[0].homeScore
        home_yellow_cards.text = data[0].homeYellowCards

        if (data[0].homeShots.toString().trim() == "null") {
            home_shots.text = "-"
        } else {
            home_shots.text = data[0].homeShots
        }

        if (data[0].homeRedCards == "null") {
            home_red_cards.text = "-"
        } else {
            home_red_cards.text = data[0].homeRedCards
        }

        away_name.text = data[0].awayTeam
        away_score.text = data[0].awayScore
        away_yellow_cards.text = data[0].awayYellowCards

        if (data[0].awayShots.toString().trim() == "null") {
            away_shots.text = "-"
        } else {
            away_shots.text = data[0].awayShots
        }

        if (data[0].awayRedCards == "null") {
            away_red_cards.text = data[0].awayRedCards
        } else {
            away_red_cards.text = data[0].awayRedCards
        }

        val parser = SimpleDateFormat("yyyy-mm-dd")
        val formatter = SimpleDateFormat("EEE, dd, mm, yyyy")
        val date: String = formatter.format(parser.parse(data[0].matchDate))
        date_event.text = date
    }

    private fun showHomeTeamDetail(data: MutableList<Team>) {
        Glide.with(this)
            .load(data[0].teamBadge)
            .into(home_image)
    }

    private fun showAwayTeamDetail(data: MutableList<Team>) {
        Glide.with(this)
            .load(data[0].teamBadge)
            .into(away_image)
    }

    private fun addFavorite() {
        try {
            database.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.MATCH_ID to match.matchId,
                    Favorite.MATCH_DATE to match.matchDate,
                    Favorite.HOME_NAME to match.homeTeam,
                    Favorite.HOME_SCORE to match.homeScore,
                    Favorite.AWAY_NAME to match.awayTeam,
                    Favorite.AWAY_SCORE to match.awayScore
                )
            }
            Toast.makeText(this, "Success Add to Favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(
                    Favorite.TABLE_FAVORITE, "(EVENT_ID = {id})",
                    "id" to matchId
                )
            }
            Toast.makeText(this, "Success Removed from Favorite", Toast.LENGTH_SHORT).show()
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

    private fun favoriteState() {
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs(
                    "(EVENT_ID = {id})",
                    "id" to matchId
                )
            val favorite = result.parseList(classParser<Favorite>())
            if (favorite.isNotEmpty()) isFavorite = true
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            loading_detail_event.visibility = View.VISIBLE
        } else
            loading_detail_event.visibility = View.GONE
    }
}

