package com.smk.futbol.ui.detail


import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.smk.futbol.MainActivity.Companion.LEAGUE_ID
import com.smk.futbol.R
import com.smk.futbol.data.LeagueEntity
import com.smk.futbol.repository.league.LeagueRepository
import com.smk.futbol.ui.ViewPagerAdapter
import com.smk.futbol.ui.event.EventViewModel
import com.smk.futbol.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_detail.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class LeagueDetailActivity : AppCompatActivity() {
    private lateinit var detailViewModel: LeagueDetailViewModel
    private lateinit var searchViewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail League"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPagerAdapter =
            ViewPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(view_pager)

        detailViewModel = ViewModelProvider(
            this, LeagueDetailFactory(this, Bundle(), LeagueRepository.instance)
        )[LeagueDetailViewModel::class.java].apply {
            leagueObservable.observe(
                this@LeagueDetailActivity,
                Observer(this@LeagueDetailActivity::handleState)
            )
            if (leagueObservable.value?.data == null) {
                val league = intent.getStringExtra(LEAGUE_ID)
                getDetailLeague(league)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(this@LeagueDetailActivity, SearchActivity::class.java).apply {
                    putExtra("SEARCH_MATCH", query)
                }
                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
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

    private fun handleState(viewState: LeagueDetailViewState?) {
        viewState?.data?.let { showDetail(it) }
    }

//    private fun handleStateSearch(viewState: EventViewState?) {
//        viewState?.data?.let { showEvent(it) }
//    }


    private fun showDetail(leagues: MutableList<LeagueEntity>) {
        name_league.text = leagues[0].leagueName
        desc_league.text = leagues[0].leagueDesc
        Glide.with(this)
            .load(leagues[0].leagueBadge)
            .into(image_league)

    }

    //    private fun showEvent(events: MutableList<Event>) {
//        name_league.text = events[0].strHomeTeam
//        name_league.text = events[0].strAwayTeam
//        name_league.text = events[0].strDate
//    }
}




