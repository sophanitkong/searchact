package com.searchact.app.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.BaseActivity
import com.searchact.app.R
import com.searchact.app.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupToolbar()
        setEvent()
    }

    private fun setEvent() {
        btnSignUp.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnSignUp.id -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
