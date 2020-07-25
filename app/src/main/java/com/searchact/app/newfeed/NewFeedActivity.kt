package com.searchact.app.newfeed

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.createjobreview.CreatedJobReviewActivity
import com.searchact.app.profile.ListingPostAdapter
import com.searchact.app.profile.OnItemPostClickedListener
import kotlinx.android.synthetic.main.activity_new_feed.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewFeedActivity : AppCompatActivity() {

    private lateinit var newFeedAdapter: ListingPostAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_feed)

        newFeedAdapter = ListingPostAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcNewFeed.layoutManager = layoutManager
        rcNewFeed.adapter = newFeedAdapter

        setupToolbar()
        setupAdapter()
    }

    private fun setupAdapter() {
        newFeedAdapter.post.clear()
        for (index in 0..10) newFeedAdapter.post.add("$index")
        newFeedAdapter.notifyDataSetChanged()

        newFeedAdapter.listener = object : OnItemPostClickedListener {
            override fun onItemClicked() {
                val intent = Intent(this@NewFeedActivity, CreatedJobReviewActivity::class.java)
                intent.putExtra("is_new_feed", true)
                startActivity(intent)
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "New Feeds"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
