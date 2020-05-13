package com.smk.futbol.ui


import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.smk.futbol.R
import com.smk.futbol.model.Leaguee
import com.smk.futbol.ui.detail.LeagueDetailViewModel
import com.smk.futbol.ui.detail.LeagueDetailViewState
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

        viewModel = ViewModelProviders.of(this).get(LeagueDetailViewModel::class.java).apply {
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

    private fun handleState(viewState: LeagueDetailViewState) {
        viewState.data?.let { showDetail(it) }
    }

    private fun showDetail(data: Leaguee) {
        name_league.text = data.name
    }
}
