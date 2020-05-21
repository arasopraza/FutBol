package com.smk.futbol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smk.futbol.data.LeagueList
import com.smk.futbol.ui.league.LeagueAdapter
import com.smk.futbol.utils.LeagueDummy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<LeagueList> = arrayListOf()

    companion object {
        const val LEAGUE_ID = "league_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.addAll(LeagueDummy.listData)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        league_list.adapter = LeagueAdapter(list)
    }
}
