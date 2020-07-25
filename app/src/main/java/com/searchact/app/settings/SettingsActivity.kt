package com.searchact.app.settings

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.R
import com.searchact.app.aboutus.AboutUsActivity
import com.searchact.app.contactus.ContactUsActivity
import com.searchact.app.privacy.PrivacyActivity
import com.searchact.app.termcondition.TermConditionActivity
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupToolbar()
        setEvent()
    }

    private fun setEvent() {
        llPrivacy.setOnClickListener(onClicked)
        llTermCondition.setOnClickListener(onClicked)
        llContactUs.setOnClickListener(onClicked)
        llAboutUs.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            llPrivacy.id -> {
                startActivity(Intent(this, PrivacyActivity::class.java))
            }

            llTermCondition.id -> {
                startActivity(Intent(this, TermConditionActivity::class.java))
            }

            llContactUs.id -> {
                startActivity(Intent(this, ContactUsActivity::class.java))
            }

            llAboutUs.id -> {
                startActivity(Intent(this, AboutUsActivity::class.java))
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Setting"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
