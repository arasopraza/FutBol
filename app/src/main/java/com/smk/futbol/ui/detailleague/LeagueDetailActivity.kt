package com.smk.futbol.ui.detailleague


import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.smk.futbol.R
import com.smk.futbol.data.LeagueRepository
import com.smk.futbol.model.League
import com.smk.futbol.ui.league.LeagueFragment.Companion.LEAGUE_ID
import com.smk.futbol.ui.search.SearchActivity
import com.smk.futbol.ui.search.SearchActivity.Companion.QUERY_MATCH
import kotlinx.android.synthetic.main.activity_detail_league.*

@Suppress(
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class LeagueDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: LeagueDetailViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    var idLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        supportActionBar?.title = getString(R.string.detail_league)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPagerAdapter =
            ViewPagerAdapter(
                this,
                supportFragmentManager
            )
        view_pager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(view_pager)

        val getIdLeague = intent.getStringExtra(LEAGUE_ID)
        idLeague = getIdLeague

        initObservable()
        showLoading(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(this@LeagueDetailActivity, SearchActivity::class.java).apply {
                    putExtra(QUERY_MATCH, query)
                }
                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initObservable() {
        val idLeague = intent.getStringExtra(LEAGUE_ID)
        viewModelFactory = ViewModelProvider(
            this,
            LeagueDetailFactory(LeagueRepository.instance)
        )
        viewModel = viewModelFactory[LeagueDetailViewModel::class.java].apply {
            leagueObservable.observe(
                this@LeagueDetailActivity,
                Observer(this@LeagueDetailActivity::handleState)
            )
            setDetailLeague(idLeague)
        }
    }

    private fun handleState(viewState: LeagueDetailViewState?) {
        if (!viewState?.loading!!) {
            showLoading(false)
        }
        viewState.data?.let { showDetail(it) }
    }

    private fun showDetail(leagues: MutableList<League>) {
        name_league.text = leagues[0].leagueName
        country_league.text = leagues[0].leagueCountry
        desc_league.text = leagues[0].leagueDesc
        Glide.with(this)
            .load(leagues[0].leagueBadge)
            .into(image_league)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressbar.visibility = View.VISIBLE
        } else
            progressbar.visibility = View.GONE
    }
}




