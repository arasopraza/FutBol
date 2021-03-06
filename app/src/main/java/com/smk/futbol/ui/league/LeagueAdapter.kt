package com.smk.futbol.ui.league

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smk.futbol.R
import com.smk.futbol.model.LeagueDummy
import com.smk.futbol.ui.detailleague.LeagueDetailActivity
import com.smk.futbol.ui.league.LeagueFragment.Companion.LEAGUE_ID
import kotlinx.android.synthetic.main.item_list_league.view.*

class LeagueAdapter(private val listLeague: ArrayList<LeagueDummy>) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_league, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listLeague.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listLeague[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.text_item_name
        private val image = itemView.image_item

        fun bindItem(items: LeagueDummy) {
            with(itemView) {
                name.text = items.name
                Glide.with(itemView.context)
                    .load(items.image)
                    .into(image)

                //intent to another activity
                itemView.setOnClickListener {
                    val idLeague = Intent(context, LeagueDetailActivity::class.java).apply {
                        putExtra(LEAGUE_ID, items.id)
                    }
                    context.startActivity(idLeague)
                }
            }
        }
    }
}