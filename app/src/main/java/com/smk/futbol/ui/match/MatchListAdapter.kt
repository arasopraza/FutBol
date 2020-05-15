package com.smk.futbol.ui.match

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smk.futbol.MainActivity
import com.smk.futbol.R
import com.smk.futbol.model.League
import com.smk.futbol.ui.DetailMatchActivity
import kotlinx.android.synthetic.main.item_list_match.view.*

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    private val matchlist = mutableListOf<>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_match, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = league.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(league[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameHome = itemView.name_home
        private val nameAway = itemView.name_away
        private val imageHome = itemView.image_home
        private val imageAway = itemView.image_home

        fun bindItem(items: League) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(items.leagueBadge)
                    .apply(RequestOptions().override(55, 55))
                    .into(imageHome)

                Glide.with(itemView.context)
                    .load(items.leagueBadge)
                    .apply(RequestOptions().override(55, 55))
                    .into(imageAway)

                nameHome.text = items.leagueName
                nameAway.text = items.leagueName

                //intent to another activity
                itemView.setOnClickListener {
                    val intent = Intent(context, DetailMatchActivity::class.java).apply {
                        putExtra(MainActivity.LEAGUE_DATA, items)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}