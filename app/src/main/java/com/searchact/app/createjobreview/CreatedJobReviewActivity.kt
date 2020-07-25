package com.searchact.app.createjobreview

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import com.searchact.app.R
import com.searchact.app.createjob.CreateJobRequirementActivity
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_created_job_review.*

class CreatedJobReviewActivity : AppCompatActivity() {

    private var isNewFeed: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_created_job_review)

        isNewFeed = intent?.getBooleanExtra("is_new_feed", false)

        setupToolbar()
        setView()
        setEvent()
    }

    private fun setView() {
        llBottomJob.visibility = if (isNewFeed!!) View.GONE else View.VISIBLE
        llBottomToolbar.visibility = if (isNewFeed!!) View.GONE else View.VISIBLE
    }

    private fun setEvent() {
        btnEditJob.setOnClickListener(onClicked)
        btnDeleteJob.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnEditJob.id -> {
                val intent = Intent(this, CreateJobRequirementActivity::class.java)
                intent.putExtra("is_job_edited", true)
                startActivity(intent)
            }

            btnDeleteJob.id -> {
                Core.showDeleteDialog(
                    this,
                    "Delete Job Announcement",
                    "Are you sure you want to delete the job announcement name : New Manager Needed?"
                )
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(anim_toolbar_job)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        collapsing_toolbar.title = ""

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapsing_toolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
                    collapsing_toolbar
                )
            ) {
                anim_toolbar_job.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.black),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar_job.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left)
            } else {
                anim_toolbar_job.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.black),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar_job.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
