package com.smk.futbol.ui.match.previous

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.data.MatchRepository
import com.smk.futbol.model.Match
import com.smk.futbol.ui.detailleague.LeagueDetailActivity
import com.smk.futbol.ui.match.MatchAdapter
import com.smk.futbol.ui.match.MatchViewState
import kotlinx.android.synthetic.main.fragment_match_prev.*


class MatchPrevFragment : Fragment() {
    private lateinit var viewModel: MatchPrevViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    private lateinit var adapter: MatchAdapter
    private lateinit var activity: LeagueDetailActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match_prev, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MatchAdapter()
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
            MatchPrevFactory(MatchRepository.instance)
        )
        viewModel = viewModelFactory[MatchPrevViewModel::class.java].apply {
            matchObservable.observe(
                viewLifecycleOwner,
                Observer(this@MatchPrevFragment::handleState)
            )
            setPrevMatch(activity.idLeague)
        }
    }

    private fun handleState(viewState: MatchViewState?) {
        viewState?.let {
            it.data?.let { data -> showRecyclerView(data) }
        }
    }

    private fun showRecyclerView(data: MutableList<Match>) {
        adapter.setEvent(data)
        adapter.notifyDataSetChanged()
        if (data.size == 0) {
            Toast.makeText(context, "Match not found", Toast.LENGTH_SHORT).show()
        }
    }
}

