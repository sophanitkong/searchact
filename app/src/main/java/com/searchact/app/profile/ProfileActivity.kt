package com.searchact.app.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.createjobreview.CreatedJobReviewActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var postAdapter: ListingPostAdapter
    private lateinit var postLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        postAdapter = ListingPostAdapter(arrayListOf())
        postLayoutManager = LinearLayoutManager(this)

        rcListingPost.layoutManager = postLayoutManager
        rcListingPost.adapter = postAdapter

        setupToolbar()
        setupPostAdapter()
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Profile"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupPostAdapter() {
        postAdapter.post.clear()
        for (index in 0..10) postAdapter.post.add("$index")
        postAdapter.notifyDataSetChanged()

        postAdapter.listener = object : OnItemPostClickedListener {
            override fun onItemClicked() {
                val intent = Intent(this@ProfileActivity, CreatedJobReviewActivity::class.java)
                intent.putExtra("is_new_feed", true)
                startActivity(intent)
            }
        }
    }
}
