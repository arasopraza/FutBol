package com.smk.futbol.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smk.futbol.R
import com.smk.futbol.model.Favorite
import com.smk.futbol.ui.detailmatch.MatchDetailActivity
import kotlinx.android.synthetic.main.item_list_match.view.*

class FavoriteAdapter(private val favorite: List<Favorite>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_match, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(favorite[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val eventDate = itemView.date_event
        private val nameHome = itemView.home_name
        private val nameAway = itemView.away_name
        private val scoreHome = itemView.home_score
        private val scoreAway = itemView.away_score

        fun bindItem(items: Favorite) {
            with(itemView) {
                eventDate.text = items.matchDate
                nameHome.text = items.homeName
                scoreHome.text = items.homeScore
                nameAway.text = items.awayName
                scoreAway.text = items.awayScore

//            intent to another activity
                itemView.setOnClickListener {
                    val intent = Intent(context, MatchDetailActivity::class.java).apply {
                        putExtra("EVENT_DETAIL", items.matchId)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}
