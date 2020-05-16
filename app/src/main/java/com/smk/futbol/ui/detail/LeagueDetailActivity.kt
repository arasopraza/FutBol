package com.smk.futbol.ui.detail


import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.model.League
import com.smk.futbol.repository.LeagueRepository
import com.smk.futbol.ui.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var viewModel: LeagueDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail League"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPagerAdapter =
            ViewPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(view_pager)

        val factory = LeagueDetailFactory(LeagueRepository.instance)
        viewModel = ViewModelProvider(
            this,
            factory
        )[LeagueDetailViewModel::class.java].apply {
            viewState.observe(
                this@DetailActivity,
                Observer(this@DetailActivity::handleState)
            )
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
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@DetailActivity, query, Toast.LENGTH_SHORT).show()
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

    private fun showDetail(data: MutableList<League>) {
        name_league.text = data[0].leagueName
    }
}



