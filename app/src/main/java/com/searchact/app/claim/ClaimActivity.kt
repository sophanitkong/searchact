package com.searchact.app.claim

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.R
import com.searchact.app.payment.PaymentActivity
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_claim.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ClaimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_claim)

        setupToolbar()
        setEvent()
    }

    private fun setEvent() {
        btnClaim.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnClaim.id -> {
                Core.showSuccessReportFlagDialog(
                    this,
                    "Request Send",
                    "Thank You! Your request has been send successfully. Our team will check your claim request."
                ) {
                    startActivity(Intent(this, PaymentActivity::class.java))
                }
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Claim Your Listing"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
