package com.searchact.app.events.changelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_change_list.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ChangeListActivity : AppCompatActivity() {

    private lateinit var changeListEventAdapter: ChangeListEventAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_list)

        changeListEventAdapter = ChangeListEventAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcEventChangeList.layoutManager = layoutManager
        rcEventChangeList.adapter = changeListEventAdapter

        setupToolbar()
        setupAdapter()
    }

    private fun setupAdapter() {
        changeListEventAdapter.events.clear()
        for (index in 0..5) changeListEventAdapter.events.add("$index")
        changeListEventAdapter.notifyDataSetChanged()
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Change List"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
