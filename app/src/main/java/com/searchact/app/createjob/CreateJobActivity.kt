package com.searchact.app.createjob

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_create_job.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CreateJobActivity : AppCompatActivity() {

    private lateinit var jobCategoryAdapter: JobCategoryAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_job)

        jobCategoryAdapter = JobCategoryAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcJobCategory.layoutManager = layoutManager
        rcJobCategory.adapter = jobCategoryAdapter

        setupToolbar()
        setupAdapter()
        setEvent()
    }

    private fun setEvent() {
        btnCreateJobNext.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnCreateJobNext.id -> {
                startActivity(
                    Intent(
                        this@CreateJobActivity,
                        CreateJobRequirementActivity::class.java
                    )
                )
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.create_job)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        jobCategoryAdapter.jobCategories.clear()
        for (index in 0..2) jobCategoryAdapter.jobCategories.add("$index")
        jobCategoryAdapter.notifyDataSetChanged()
    }
}
