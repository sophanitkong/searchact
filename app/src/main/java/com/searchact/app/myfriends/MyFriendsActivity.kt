package com.searchact.app.myfriends

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_my_friends.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MyFriendsActivity : AppCompatActivity() {

    private lateinit var adapter: MyFriendsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_friends)

        layoutManager = LinearLayoutManager(this)
        adapter = MyFriendsAdapter(arrayListOf())

        rcMyFriends.layoutManager = layoutManager
        rcMyFriends.adapter = adapter

        setupToolbar()
        setAdapter()
    }

    private fun setAdapter() {
        adapter.data.clear()
        for (index in 0..10) adapter.data.add("$index")
        adapter.notifyDataSetChanged()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "My Friends"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
