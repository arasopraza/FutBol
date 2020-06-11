package com.smk.futbol.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smk.futbol.R
import com.smk.futbol.model.Favorite
import com.smk.futbol.data.source.local.database
import kotlinx.android.synthetic.main.fragment_prev_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteFragment : Fragment() {
    private lateinit var adapter: FavoriteAdapter
    private var favorites: MutableList<Favorite> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = FavoriteAdapter(favorites)
        event_list.adapter = adapter
        showFavorite()
    }

    override fun onResume() {
        super.onResume()
        showFavorite()
    }

    private fun showFavorite() {
        favorites.clear()
        context?.database?.use {
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}
