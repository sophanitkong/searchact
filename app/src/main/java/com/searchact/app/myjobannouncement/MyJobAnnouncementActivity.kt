package com.searchact.app.myjobannouncement

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.createjob.CreateJobActivity
import com.searchact.app.createjobreview.CreatedJobReviewActivity
import com.searchact.app.viewdetail.adapter.JobAnnouncementAdapter
import com.searchact.app.viewdetail.adapter.OnItemJobClickedListener
import kotlinx.android.synthetic.main.activity_my_job_announcement.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class MyJobAnnouncementActivity : AppCompatActivity() {

    private lateinit var jobAnnouncementAdapter: JobAnnouncementAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_job_announcement)

        jobAnnouncementAdapter = JobAnnouncementAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcMyJobAnnouncement.layoutManager = layoutManager
        rcMyJobAnnouncement.adapter = jobAnnouncementAdapter

        setupToolbar()
        setupAdapter()
        setEvent()
    }

    private fun setEvent() {
        floatingJobAnnounce.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            floatingJobAnnounce.id -> {
                startActivity(
                    Intent(
                        this@MyJobAnnouncementActivity,
                        CreateJobActivity::class.java
                    )
                )
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "My Job Announcements"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        jobAnnouncementAdapter.jobs.clear()
        for (index in 0..10) jobAnnouncementAdapter.jobs.add("$index")
        jobAnnouncementAdapter.notifyDataSetChanged()

        jobAnnouncementAdapter.listener = object : OnItemJobClickedListener {
            override fun onItemClicked() {
                startActivity(
                    Intent(
                        this@MyJobAnnouncementActivity,
                        CreatedJobReviewActivity::class.java
                    )
                )
            }
        }
    }
}
