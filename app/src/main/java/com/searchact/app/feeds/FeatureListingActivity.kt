package com.searchact.app.feeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.models.FeatureListing
import kotlinx.android.synthetic.main.activity_feature_listing.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class FeatureListingActivity : AppCompatActivity() {

    private lateinit var adapter: FeatureListingAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_listing)

        adapter = FeatureListingAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcFeatureListing.layoutManager = layoutManager

        setupToolbar()
        setupAdapter()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Feature Listing"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        adapter.features.clear()
        adapter.features.add(
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )
        )
        adapter.features.add(
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )
        )
        adapter.features.add(
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )
        )
        adapter.features.add(
            FeatureListing(
                image = R.drawable.resturent_half_corner,
                title = "The Little Kitchen",
                date = "March 12,2019",
                location = "in Irish, Near by food place, Steak Hou… ",
                address = "129 Leeson Street Upper Dublin R",
                phoneNumber = "35316718654",
                dateTime = "Today 10:30am - 11:30pm",
                website = "thefarmfood.ie", vote = 10, rate = 4
            )
        )
        adapter.notifyDataSetChanged()

        rcFeatureListing.adapter = adapter
    }
}
