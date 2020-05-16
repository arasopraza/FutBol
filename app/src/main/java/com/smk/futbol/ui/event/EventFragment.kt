package com.smk.futbol.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smk.futbol.R
import com.smk.futbol.model.Event
import com.smk.futbol.repository.EventRepository
import kotlinx.android.synthetic.main.fragment_match.*


class EventFragment : Fragment() {
    private lateinit var viewModel: EventViewModel
    private lateinit var adapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = EventAdapter()
        match_list.adapter = adapter
        viewModel = ViewModelProvider(
            this, EventFactory(this, Bundle(), EventRepository.instance)
        )[EventViewModel::class.java].apply {
            eventObservable.observe(
                viewLifecycleOwner,
                Observer(this@EventFragment::handleState)
            )
            if (eventObservable.value?.data == null) {
                getPrevMatch("")
            }
        }
    }

    private fun handleState(viewState: EventViewState?) {
        viewState?.let {
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showData(data: MutableList<Event>) {
        adapter.setMatch(data)
    }

    private fun showError(error: Exception) {

    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(index: Int): EventFragment {
            val fragment = EventFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
    }
}

