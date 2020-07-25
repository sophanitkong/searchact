package com.searchact.app.productcategory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.feeds.FeatureListingAdapter
import com.searchact.app.models.FeatureListing
import kotlinx.android.synthetic.main.activity_product_category.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ProductCategoryActivity : AppCompatActivity() {

    private var categoryName: String? = ""
    private lateinit var adapter: FeatureListingAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_category)

        adapter = FeatureListingAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcProductCategory.layoutManager = layoutManager
        rcProductCategory.adapter = adapter

        categoryName = intent?.getStringExtra("category_name")

        setupToolbar(categoryName!!)
        setupAdapter()
    }

    private fun setupToolbar(categoryName: String) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = categoryName
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        adapter.features.clear()
        for (index in 1..10) {
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
        }
    }
}
