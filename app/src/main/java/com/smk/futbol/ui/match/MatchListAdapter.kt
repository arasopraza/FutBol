package com.smk.futbol.ui.match

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smk.futbol.MainActivity
import com.smk.futbol.R
import com.smk.futbol.model.Event
import com.smk.futbol.model.League
import com.smk.futbol.ui.DetailMatchActivity
import kotlinx.android.synthetic.main.item_list_match.view.*

class MatchListAdapter : RecyclerView.Adapter<MatchListAdapter.ViewHolder>() {
    private val matchList = mutableListOf<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_match, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = matchList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(matchList[position])
    }

    fun setMatch(matchs: MutableList<Event>) {
        matchs.clear()
        matchs.addAll(matchs)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameHome = itemView.name_home
        private val nameAway = itemView.name_away
        private val imageHome = itemView.image_home
        private val imageAway = itemView.image_home

        fun bindItem(items: Event) {
//            with(itemView) {
//                Glide.with(itemView.context)
//                    .load(items.)
//                    .apply(RequestOptions().override(55, 55))
//                    .into(imageHome)
//
//                Glide.with(itemView.context)
//                    .load(items.leagueBadge)
//                    .apply(RequestOptions().override(55, 55))
//                    .into(imageAway)

            nameHome.text = items.strHomeTeam
            nameAway.text = items.strAwayTeam

            //intent to another activity
        }
    }
}
