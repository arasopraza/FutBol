package com.smk.futbol.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.smk.futbol.model.Leaguee
import com.smk.futbol.R
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : Fragment() {
    private var items: MutableList<Leaguee> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        match_list?.setHasFixedSize(true)
        initData()
        showRecyclerView()
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.match_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        items.clear()
        for (i in name.indices) {
            items.add(
                Leaguee(
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }
        // Recycle the typed array
        image.recycle()
    }

    private fun showRecyclerView() {
        match_list?.layoutManager = LinearLayoutManager(context)
        match_list?.adapter = MatchAdapter(items)
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

