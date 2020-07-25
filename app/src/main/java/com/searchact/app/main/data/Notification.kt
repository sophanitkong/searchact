package com.searchact.app.main.data

import android.text.format.DateFormat
import java.util.*

data class Notification(
    var backgroundColor:Int? = null,
    var title:String? = null,
    var dateTime:String = DateFormat.format("dd MMM yyyy 'at' hh:mm a", Date().time).toString(),

    @Transient
    var viewType: Int? = null,
    @Transient
    var stickyTitle: String? = null
)