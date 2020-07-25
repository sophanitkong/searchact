package com.searchact.app.events.create

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.R
import com.searchact.app.events.changelist.ChangeListActivity
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_create_event.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CreateEventActivity : AppCompatActivity() {

    var isEventEdited: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        isEventEdited = intent?.getBooleanExtra("is_event_edited", false)

        setupToolbar()
        setView()
        setEvent()
    }

    private fun setView() {
        tvChangeListEvent.visibility = if (isEventEdited!!) View.VISIBLE else View.GONE
        tvPinOnMaps.text = if (isEventEdited!!) "Repin in Map" else "Pin in Map"
    }

    private fun setEvent() {
        btnEventSave.setOnClickListener(onClicked)
        tvChangeListEvent.setOnClickListener(onClicked)
        etStartDate.setOnClickListener(onClicked)
        etEndDate.setOnClickListener(onClicked)
        etStartHour.setOnClickListener(onClicked)
        etEndHour.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnEventSave.id -> {
                finish()
            }

            tvChangeListEvent.id -> {
                startActivity(Intent(this, ChangeListActivity::class.java))
            }

            etStartDate.id -> {
                Core.showDatePicker(this)
            }

            etEndDate.id -> {
                Core.showDatePicker(this)
            }

            etStartHour.id -> {
                Core.showTimePicker(this)
            }

            etEndHour.id -> {
                Core.showTimePicker(this)
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = if (isEventEdited!!) "Edit Event" else "Create Event"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
