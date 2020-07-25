package com.searchact.app.main.data

data class Settings(
    var icon: Int,
    var title: String,
    var subTitle: String,
    var isLogout: Boolean = false,
    var hasSubTitle: Boolean = true
)