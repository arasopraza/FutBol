package com.smk.futbol.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.data.Event
import com.smk.futbol.repository.event.EventRepository
import com.smk.futbol.ui.event.EventAdapter
import com.smk.futbol.ui.event.EventViewState
import kotlinx.android.synthetic.main.activity_search.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SearchActivity : AppCompatActivity() {

    companion object {
        const val QUERY_MATCH = "query_match"
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportActionBar?.title = "Search Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = EventAdapter()
        event_search.adapter = adapter
        initObservable()

    }

    private fun initObservable() {
        val query = intent.getStringExtra(QUERY_MATCH)

        viewModelFactory = ViewModelProvider(
            this, SearchFactory(
                this, Bundle(), EventRepository.instance
            )
        )
        viewModel = viewModelFactory[SearchViewModel::class.java].apply {
            searchObservable.observe(
                this@SearchActivity, Observer(
                    this@SearchActivity::handleState
                )
            )
            getSearchMatch(query)
        }
    }

    private fun handleState(viewState: EventViewState?) {
        viewState?.let {
            it.data?.let { data -> showRecyclerView(data) }
        }

    }

    private fun showRecyclerView(data: MutableList<Event>) {
        adapter.setEvent(data)
    }
}
