package com.smk.futbol.ui.event.previous

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.data.Event
import com.smk.futbol.repository.event.EventRepository
import com.smk.futbol.ui.detail_league.LeagueDetailActivity
import com.smk.futbol.ui.event.EventAdapter
import com.smk.futbol.ui.event.EventViewState
import kotlinx.android.synthetic.main.fragment_match.*


class EventFragment : Fragment() {

    private lateinit var viewModel: EventViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    private lateinit var adapter: EventAdapter
    private lateinit var activity: LeagueDetailActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EventAdapter()
        event_list.adapter = adapter
        initObservable()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as LeagueDetailActivity
    }

    private fun initObservable() {
        viewModelFactory = ViewModelProvider(
            this,
            EventFactory(
                this,
                Bundle(),
                EventRepository.instance
            )
        )
        viewModel = viewModelFactory[EventViewModel::class.java].apply {
            eventObservable.observe(
                viewLifecycleOwner,
                Observer(this@EventFragment::handleState)
            )
            setPrevMatch(activity.idLeague)
        }
    }

    private fun handleState(viewState: EventViewState?) {
        viewState?.let {
            it.data?.let { data -> showRecyclerView(data) }
        }
    }

    private fun showRecyclerView(data: MutableList<Event>) {
        adapter.setEvent(data)
        adapter.notifyDataSetChanged()
    }
}

