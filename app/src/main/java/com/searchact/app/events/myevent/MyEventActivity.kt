package com.searchact.app.events.myevent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.events.create.CreateEventActivity
import com.searchact.app.events.detail.EventDetailActivity
import kotlinx.android.synthetic.main.activity_my_event.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class MyEventActivity : AppCompatActivity() {

    private lateinit var eventAdapter: MyEventAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_event)

        eventAdapter = MyEventAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcMyEvent.layoutManager = layoutManager
        rcMyEvent.adapter = eventAdapter

        setupToolbar()
        setupAdapter()
        setEvent()
    }

    private fun setEvent() {
        btnEventFloating.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnEventFloating.id -> {
                startActivity(Intent(this, CreateEventActivity::class.java))
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "My Event"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        eventAdapter.events.clear()
        for (index in 0..10) eventAdapter.events.add("$index")
        eventAdapter.notifyDataSetChanged()

        eventAdapter.listener = object : OnItemEventClickedListener {
            override fun onItemClicked() {
                startActivity(Intent(this@MyEventActivity, EventDetailActivity::class.java))
            }
        }
    }
}
