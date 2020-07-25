package com.searchact.app.reportflag

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.BaseActivity
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_report_flag.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class ReportFlagActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_flag)

        setupToolbar()
        setupSpinner()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Report Flag"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupSpinner(){
        val plants = arrayOf(
            getString(R.string.please_select_issue),
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            "Option 5"
        )

        val spinnerArrayAdapter = ArrayAdapter(
            this, R.layout.spinner_item, plants
        )

        spinner.setSelection(0)
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinner.adapter = spinnerArrayAdapter
    }
}
