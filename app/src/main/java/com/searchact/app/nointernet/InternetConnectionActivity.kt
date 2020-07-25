package com.searchact.app.nointernet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class InternetConnectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_no_internet_connection)

        setupToolbar()
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.no_internet_connection)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}