package com.smk.futbol.ui.search

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.data.source.Event
import com.smk.futbol.data.EventRepository
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
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportActionBar?.title = "Search Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        adapter = EventAdapter()
        event_search.adapter = adapter
        initObservable()
//        showLoading(true)
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
            if (searchObservable.value?.data == null) {
                setSearchMatch(query)
            }
        }
    }

    private fun handleState(viewState: EventViewState?) {
        viewState?.let {
            it.data?.let { data -> showRecyclerView(data) }
        }

    }

    private fun showRecyclerView(data: MutableList<Event>) {
        if (data.size == 0) {
            Toast.makeText(this, "Match not found", Toast.LENGTH_SHORT).show()
        } else {
            adapter.setEvent(data)
        }
    }

//    private fun showLoading(state: Boolean) {
//        if (state) {
//            progressBar.visibility = View.VISIBLE
//        } else
//            progressBar.visibility = View.GONE
//    }
}
