package com.smk.futbol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list_league.view.*

class LeagueAdapter(private val context: Context, private val items: List<League>, private val listener: (League) -> Unit)
    : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.item_list_league, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.text_item_name
        private val image = view.image_item

        fun bindItem(items: League, listener: (League) -> Unit) {
            Glide.with(itemView.context)
                .load(items.image)
                .apply(RequestOptions().override(55, 55))
                .into(image)

            name.text = items.name

            //intent to another activity
            itemView.setOnClickListener { listener(items)
            }
        }
    }
}