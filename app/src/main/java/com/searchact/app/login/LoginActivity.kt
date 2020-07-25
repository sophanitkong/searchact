package com.searchact.app.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.BaseActivity
import com.searchact.app.R
import com.searchact.app.lostpassword.LostPasswordActivity
import com.searchact.app.main.MainActivity
import com.searchact.app.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setEvent()
    }

    fun setEvent() {
        tvRegister.setOnClickListener(onClicked)
        tvLostPassword.setOnClickListener(onClicked)
        btnSignIn.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            tvLostPassword.id -> {
                startActivity(Intent(this, LostPasswordActivity::class.java))
            }
            tvRegister.id -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            btnSignIn.id -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}
