package com.searchact.app.lostpassword

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.R
import kotlinx.android.synthetic.main.activity_lost_password.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class LostPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_password)

        setupToolbar()
        setEvent()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    private fun setEvent() {
        tvResendAgain.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            tvResendAgain.id -> {
                showResendDialog()
            }
        }
    }

    private fun showResendDialog() {
        val builder =
            AlertDialog.Builder(this@LostPasswordActivity)
        val viewGroup = findViewById<ViewGroup>(R.id.content)
        val dialogView: View =
            LayoutInflater.from(this@LostPasswordActivity)
                .inflate(R.layout.custom_dialog, viewGroup, false)

        builder.setView(dialogView)
        val alertDialog = builder.create()
        dialogView.btnOK.setOnClickListener { alertDialog.dismiss() }
        dialogView.btnEmail.setOnClickListener { alertDialog.dismiss() }
        alertDialog.setCancelable(false)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
