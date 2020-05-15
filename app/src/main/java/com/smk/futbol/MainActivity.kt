package com.smk.futbol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smk.futbol.model.LeagueList
import com.smk.futbol.ui.league.LeagueAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var items: MutableList<LeagueList> = mutableListOf()

    companion object {
        const val LEAGUE_DATA = "league_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        league_list.setHasFixedSize(true)
        initData()
        showRecyclerView()
    }

    private fun initData(){
        val id = resources.getStringArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        items.clear()
        for (i in name.indices) {
            items.add(
                LeagueList(
                    id[i],
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }
        // Recycle the typed array
        image.recycle()
    }

    private fun showRecyclerView() {
        league_list.layoutManager = LinearLayoutManager( this)
        league_list.adapter = LeagueAdapter(items)
    }
}
