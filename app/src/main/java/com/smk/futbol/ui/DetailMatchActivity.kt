package com.smk.futbol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailMatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        val tvName = name_item
        val items = intent.getParcelableExtra<League>(MainActivity.LEAGUE_DATA)
        tvName.text = items?.name
        Glide.with(this)
            .load(items?.image)
            .apply(RequestOptions().override(55, 55))
            .into(image_item)
    }
}
