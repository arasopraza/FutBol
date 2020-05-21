package com.smk.futbol.ui.event.next

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.smk.futbol.R
import com.smk.futbol.data.Event
import com.smk.futbol.repository.event.EventRepository
import com.smk.futbol.ui.event.EventAdapter
import com.smk.futbol.ui.event.EventViewState
import kotlinx.android.synthetic.main.next_event_fragment.*

class NextEventFragment : Fragment() {

    private lateinit var viewModel: NextEventViewModel
    private lateinit var viewModelFactory: ViewModelProvider
    private lateinit var adapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.next_event_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EventAdapter()
        event_list.adapter = adapter

        initObservable()
    }

    private fun initObservable() {
        viewModelFactory = ViewModelProvider(
            this,
            NextEventFactory(
                this,
                Bundle(),
                EventRepository.instance
            )
        )
        viewModel = viewModelFactory[NextEventViewModel::class.java].apply {
            eventObservable.observe(
                viewLifecycleOwner, Observer(this@NextEventFragment::handleState)
            )
            if (eventObservable.value?.data == null) {
                Toast.makeText(
                    context,
                    "Next Match Not Available During Pandemic",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                getNextMatch("4346")
            }
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
