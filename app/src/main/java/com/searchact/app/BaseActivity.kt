package com.searchact.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.searchact.app.nointernet.InternetConnectionActivity

open class BaseActivity : AppCompatActivity() {
    var isConnected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isConnected) {
            startActivity(Intent(this, InternetConnectionActivity::class.java))
        }

    }
}