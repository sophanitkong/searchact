package com.searchact.app.events.detail

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import com.searchact.app.R
import com.searchact.app.events.create.CreateEventActivity
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_event_detail.*

class EventDetailActivity : AppCompatActivity() {

    private var isFromFeedEvent: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        isFromFeedEvent = intent?.getBooleanExtra("is_from_feed_event", false)

        setupToolbar()
        setView()
        setEvent()
    }

    private fun setView() {
        llBottomEvent.visibility = if (isFromFeedEvent!!) View.GONE else View.VISIBLE
    }

    private fun setEvent() {
        btnDeleteEvent.setOnClickListener(onClicked)
        btnEditEvent.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnDeleteEvent.id -> {
                Core.showDeleteDialog(
                    this,
                    "Delete Event",
                    "Are you sure you want to delete the Event Name : Electro Night Party?"
                )
            }

            btnEditEvent.id -> {
                val intent = Intent(this, CreateEventActivity::class.java)
                intent.putExtra("is_event_edited", true)
                startActivity(intent)
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(anim_toolbar_event)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        collapsing_toolbar.title = ""

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapsing_toolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
                    collapsing_toolbar
                )
            ) {
                anim_toolbar_event.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar_event.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_white)
            } else {
                anim_toolbar_event.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar_event.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_white)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
