package com.smk.futbol.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smk.futbol.model.Leaguee
import com.smk.futbol.MainActivity.Companion.LEAGUE_DATA
import com.smk.futbol.R
import kotlinx.android.synthetic.main.item_list_league.view.*

class LeagueAdapter(private val leaguee: List<Leaguee>)
    : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_league, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = leaguee.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(leaguee[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.text_item_name
        private val image = itemView.image_item

        fun bindItem(items: Leaguee) {
            with(itemView) {
            Glide.with(itemView.context)
                .load(items.image)
                .apply(RequestOptions().override(55, 55))
                .into(image)

            name.text = items.name

            //intent to another activity
            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(LEAGUE_DATA, items)
                }
                context.startActivity(intent)
            }
            }
        }
    }
}