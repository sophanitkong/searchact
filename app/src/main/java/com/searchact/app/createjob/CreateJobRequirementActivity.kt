package com.searchact.app.createjob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.searchact.app.R
import com.searchact.app.createjobreview.CreatedJobReviewActivity
import kotlinx.android.synthetic.main.activity_create_job_requirement.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CreateJobRequirementActivity : AppCompatActivity() {

    private var isJobEdited: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_job_requirement)

        isJobEdited = intent?.getBooleanExtra("is_job_edited", false)

        setupToolbar()
        setView()
        setupSpinner()
        setEvent()
    }

    private fun setView() {
        tvChangeList.visibility = if (isJobEdited!!) View.VISIBLE else View.GONE
        cardImageAttach.visibility = if (isJobEdited!!) View.VISIBLE else View.GONE
    }

    private fun setEvent() {
        btnSave.setOnClickListener(onClicked)
        tvChangeList.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnSave.id -> {
                startActivity(Intent(this, CreatedJobReviewActivity::class.java))
            }

            tvChangeList.id -> {
                startActivity(Intent(this, CreateJobActivity::class.java))
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = if (isJobEdited!!) "Edit Job" else getString(R.string.create_job)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupSpinner() {
        val plants = arrayOf(
            "Category*",
            "Category 1",
            "Category 2",
            "Category 3",
            "Category 4",
            "Category 5"
        )

        val spinnerArrayAdapter = ArrayAdapter(
            this, R.layout.spinner_item, plants
        )

        spinnerJobCategory.setSelection(0)
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerJobCategory.adapter = spinnerArrayAdapter
    }
}
