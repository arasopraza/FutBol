package com.smk.futbol.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smk.futbol.model.Leaguee
import com.smk.futbol.MainActivity
import com.smk.futbol.R
import kotlinx.android.synthetic.main.item_list_match.view.*

class MatchAdapter(private val leaguee: List<Leaguee>)
    : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_match, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = leaguee.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(leaguee[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameHome = itemView.name_home
        private val nameAway = itemView.name_away
        private val imageHome = itemView.image_home
        private val imageAway = itemView.image_home

        fun bindItem(items: Leaguee) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(items.image)
                    .apply(RequestOptions().override(55, 55))
                    .into(imageHome)

                Glide.with(itemView.context)
                    .load(items.image)
                    .apply(RequestOptions().override(55, 55))
                    .into(imageAway)

                nameHome.text = items.name
                nameAway.text = items.name

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