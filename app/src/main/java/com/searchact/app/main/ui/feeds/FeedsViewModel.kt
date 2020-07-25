package com.searchact.app.main.ui.feeds

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchact.app.feeds.ui.DealsFragment
import com.searchact.app.feeds.ui.EventsFragment
import com.searchact.app.feeds.ui.JobsAnnouncementFragment

class FeedsViewModel : ViewModel() {

    private val _fragments = MutableLiveData<ArrayList<Fragment>>().apply {
        value = arrayListOf(
            DealsFragment(),
            EventsFragment(),
            JobsAnnouncementFragment()
        )
    }
    val fragments: LiveData<ArrayList<Fragment>> = _fragments

    private val _titles = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf(
            "Deals",
            "Events",
            "Job Announcements"
        )
    }
    val titles: LiveData<ArrayList<String>> = _titles
}