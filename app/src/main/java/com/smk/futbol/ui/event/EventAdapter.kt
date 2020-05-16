package com.smk.futbol.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smk.futbol.R
import com.smk.futbol.model.Event
import kotlinx.android.synthetic.main.item_list_match.view.*

class EventAdapter : RecyclerView.Adapter<EventAdapter.ViewHolder>() {
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
