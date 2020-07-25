package com.searchact.app.main.data

import android.text.format.DateFormat
import java.util.*

data class Messages(
    var profile: Int,
    var name: String,
    var message: String,
    var date: String = DateFormat.format("dd MMM yyyy ", Date().time).toString(),
    var status: Boolean = true
)