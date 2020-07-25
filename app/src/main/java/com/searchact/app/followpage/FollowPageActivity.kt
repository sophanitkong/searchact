package com.searchact.app.followpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_follow_page.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class FollowPageActivity : AppCompatActivity() {

    private lateinit var followPageAdapter: FollowPageAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follow_page)

        followPageAdapter = FollowPageAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcFollowPage.layoutManager = layoutManager
        rcFollowPage.adapter = followPageAdapter

        setupToolbar()
        setupAdapter()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Following Page"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        followPageAdapter.data.clear()
        for (index in 0..10) followPageAdapter.data.add("$index")
        followPageAdapter.notifyDataSetChanged()
    }
}
