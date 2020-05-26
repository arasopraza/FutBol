package com.smk.futbol.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.smk.futbol.R
import com.smk.futbol.ui.event.next.NextEventFragment
import com.smk.futbol.ui.event.previous.PrevEventFragment

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TAB_TITLES = intArrayOf(
        R.string.previous,
        R.string.next
    )

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = PrevEventFragment()
            1 -> fragment = NextEventFragment()
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
