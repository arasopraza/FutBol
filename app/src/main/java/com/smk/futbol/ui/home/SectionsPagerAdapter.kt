package com.smk.futbol.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.smk.futbol.R
import com.smk.futbol.ui.favorite.FavoriteFragment
import com.smk.futbol.ui.league.LeagueFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TAB_TITLES = intArrayOf(
        R.string.league,
        R.string.favorite
    )

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = LeagueFragment()
            1 -> fragment = FavoriteFragment()
        }
        return fragment as Fragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }
}

