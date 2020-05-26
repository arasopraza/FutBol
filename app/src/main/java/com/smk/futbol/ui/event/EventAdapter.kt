package com.smk.futbol.ui.event

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smk.futbol.R
import com.smk.futbol.data.source.Event
import com.smk.futbol.ui.detail_event.EventDetailActivity
import com.smk.futbol.ui.detail_event.EventDetailActivity.Companion.EVENT_DETAIL
import kotlinx.android.synthetic.main.item_list_event.view.*

class EventAdapter : RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    private val listEvent = mutableListOf<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_event, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listEvent.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listEvent[position])
    }

    fun setEvent(data: MutableList<Event>) {
        listEvent.clear()
        listEvent.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameHome = itemView.name_home
        private val nameAway = itemView.name_away
        private val scoreHome = itemView.score_home
        private val scoreAway = itemView.score_away
        private val dateEvent = itemView.date_event

        fun bindItem(items: Event) {
            with(itemView) {
                nameHome.text = items.strHomeTeam
                scoreHome.text = items.intHomeScore
                nameAway.text = items.strAwayTeam
                scoreAway.text = items.intAwayScore
                dateEvent.text = items.strDate

                //intent to another activity
                itemView.setOnClickListener {
                    val intent = Intent(context, EventDetailActivity::class.java).apply {
                        putExtra(EVENT_DETAIL, items)
                    }
                    context.startActivity(intent)
                }

            }
        }
    }
}
