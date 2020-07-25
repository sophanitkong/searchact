package com.searchact.app.main.ui.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchact.app.R
import com.searchact.app.main.data.Settings

class MoreViewModel : ViewModel() {

    private val _settings = MutableLiveData<ArrayList<Settings>>().apply {
        value = arrayListOf(
            Settings(icon = R.drawable.ic_newfeed, title = "My Feeds", subTitle = "10 new feeds"),
            Settings(icon = R.drawable.ic_mylist, title = "My Listings", subTitle = ""),
            Settings(
                icon = R.drawable.ic_myfriend,
                title = "My Friends",
                subTitle = "8 friends requests"
            ),
            Settings(
                icon = R.drawable.ic_my_deal,
                title = "My Deals",
                subTitle = "",
                hasSubTitle = false
            ),
            Settings(
                icon = R.drawable.ic_myevent,
                title = "My Events",
                subTitle = "",
                hasSubTitle = false
            ),
            Settings(
                icon = R.drawable.ic_job_announcement,
                title = "My Job Announcements",
                subTitle = "",
                hasSubTitle = false
            ),
            Settings(
                icon = R.drawable.ic_follow_page,
                title = "Following Page",
                subTitle = "",
                hasSubTitle = false
            ),
            Settings(
                icon = R.drawable.ic_settings,
                title = "Settings",
                subTitle = "",
                hasSubTitle = false
            ),
            Settings(
                icon = R.drawable.ic_logout,
                title = "Log Out",
                subTitle = "",
                isLogout = true,
                hasSubTitle = false
            )
        )
    }
    val settings: LiveData<ArrayList<Settings>> = _settings
}