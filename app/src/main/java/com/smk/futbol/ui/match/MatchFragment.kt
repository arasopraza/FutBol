package com.smk.futbol.ui.match

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.smk.futbol.R
import com.smk.futbol.model.Event
import com.smk.futbol.repository.MatchRepository
import kotlinx.android.synthetic.main.fragment_match.*
import java.lang.Exception

class MatchFragment : Fragment() {
    private lateinit var viewModel: MatchListViewModel
    private lateinit var adapter: MatchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = MatchListAdapter()
        match_list.adapter = adapter

        val factory = MatchListFactory(MatchRepository.instance)
        viewModel = ViewModelProvider(this, factory)[MatchListViewModel::class.java].apply {
            viewState.observe(
                viewLifecycleOwner, Observer(this@MatchFragment::handleState)
            )
        }
    }

    private fun handleState(viewState: MatchViewState?) {
        viewState?.let {
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showData(data: MutableList<Event>) {
        adapter.setMatch(data)
    }

    private fun showError(error: Exception){

    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(index: Int): MatchFragment {
            val fragment = MatchFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
    }
}

