package com.searchact.app.requestfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.models.FriendRequest
import kotlinx.android.synthetic.main.activity_request_friend.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class RequestFriendActivity : AppCompatActivity() {

    private lateinit var adapter: FriendRequestAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_friend)

        adapter = FriendRequestAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcFriendRequest.layoutManager = layoutManager
        rcFriendRequest.adapter = adapter

        setupToolbar()
        setupAdapter()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.requests)
    }

    private fun setupAdapter() {
        adapter.requests.clear()
        for (index in 1..10) {
            adapter.requests.add(FriendRequest(name = "$index"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
