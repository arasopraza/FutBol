package com.smk.futbol.ui.search

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.data.MatchRepository
import com.smk.futbol.model.Match
import com.smk.futbol.ui.match.MatchAdapter
import com.smk.futbol.ui.match.MatchViewState
import kotlinx.android.synthetic.main.activity_search.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SearchActivity : AppCompatActivity() {

    companion object {
        const val QUERY_MATCH = "query_match"
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    private lateinit var adapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportActionBar?.title = getString(R.string.search_match)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = MatchAdapter()
        event_search.adapter = adapter
        initObservable()
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
        val query = intent.getStringExtra(QUERY_MATCH)

        viewModelFactory = ViewModelProvider(
            this, SearchFactory
                (MatchRepository.instance)
        )
        viewModel = viewModelFactory[SearchViewModel::class.java].apply {
            searchObservable.observe(
                this@SearchActivity, Observer(
                    this@SearchActivity::handleState
                )
            )
            if (searchObservable.value?.data == null) {
                setSearchMatch(query)
            }
        }
    }

    private fun handleState(viewState: MatchViewState?) {
        if (!viewState?.loading!!) {
            showLoading(false)
        }
        viewState.let {
            it.data?.let { data -> showRecyclerView(data) }
        }

    }

    private fun showRecyclerView(data: MutableList<Match>) {
        adapter.setEvent(data)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pb_search.visibility = View.VISIBLE
        } else
            pb_search.visibility = View.GONE
    }

}
