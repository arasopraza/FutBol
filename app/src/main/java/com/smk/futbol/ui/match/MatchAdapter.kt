package com.smk.futbol.ui.match

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smk.futbol.R
import com.smk.futbol.model.Match
import com.smk.futbol.ui.detailmatch.MatchDetailActivity
import com.smk.futbol.ui.detailmatch.MatchDetailActivity.Companion.EVENT_DETAIL
import kotlinx.android.synthetic.main.item_list_match.view.*

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    private val listEvent = mutableListOf<Match>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_match, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listEvent.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listEvent[position])
    }

    fun setEvent(data: MutableList<Match>) {
        val dataFootball = data.filter {
            it.sport == "Soccer"
        }
        listEvent.clear()
        listEvent.addAll(dataFootball)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameHome = itemView.home_name
        private val nameAway = itemView.away_name
        private val scoreHome = itemView.home_score
        private val scoreAway = itemView.away_score
        private val dateEvent = itemView.date_event

        fun bindItem(items: Match) {
            with(itemView) {
                nameHome.text = items.strHomeTeam
                scoreHome.text = items.intHomeScore
                nameAway.text = items.strAwayTeam
                scoreAway.text = items.intAwayScore
                dateEvent.text = items.strDate

                //intent to another activity
                itemView.setOnClickListener {
                    val intent = Intent(context, MatchDetailActivity::class.java).apply {
                        putExtra("EVENT_DETAIL", items.idEvent)
                    }
                    context.startActivity(intent)
                }

            }
        }
    }
}
