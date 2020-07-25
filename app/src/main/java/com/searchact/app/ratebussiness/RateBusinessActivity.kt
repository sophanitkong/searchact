package com.searchact.app.ratebussiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class RateBusinessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_business)

        setupToolbar()
    }

    fun setupToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Rate This Business"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
