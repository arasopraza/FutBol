package com.smk.futbol.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smk.futbol.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )
        view_pager.adapter = sectionsPagerAdapter
        tab_layout.setupWithViewPager(view_pager)

    }
}
