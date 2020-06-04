package com.smk.futbol.ui.league

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.smk.futbol.R
import com.smk.futbol.model.LeagueDummy
import com.smk.futbol.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_league.*

class LeagueFragment : Fragment() {
    private var dummy: ArrayList<LeagueDummy> = arrayListOf()

    companion object {
        const val LEAGUE_ID = "league_id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dummy.addAll(DataDummy.dummyData)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        league_list.adapter = LeagueAdapter(dummy)
    }
}
