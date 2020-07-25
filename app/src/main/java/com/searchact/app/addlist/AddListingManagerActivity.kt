package com.searchact.app.addlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.addlist.adapter.PositionAdapter
import kotlinx.android.synthetic.main.activity_add_listing_manager.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class AddListingManagerActivity : AppCompatActivity() {

    private lateinit var positionAdapter: PositionAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_listing_manager)

        positionAdapter = PositionAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcPosition.layoutManager = layoutManager
        rcPosition.adapter = positionAdapter

        positionAdapter.data.clear()
        for (index in 0..10) positionAdapter.data.add("$index")
        positionAdapter.notifyDataSetChanged()

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Add Listing"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
