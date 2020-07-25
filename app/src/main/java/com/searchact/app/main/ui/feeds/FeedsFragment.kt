package com.searchact.app.main.ui.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.searchact.app.R
import com.searchact.app.feeds.ui.DealsFragment
import com.searchact.app.feeds.ui.EventsFragment
import com.searchact.app.feeds.ui.JobsAnnouncementFragment
import kotlinx.android.synthetic.main.fragment_feed.view.*

class FeedsFragment : Fragment() {

    private lateinit var root: View
    private lateinit var feedsTabAdapter: FeedsTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_feed, container, false)

        feedsTabAdapter = FeedsTabAdapter(
            arrayListOf(),
            arrayListOf(),
            childFragmentManager
        )

        feedsTabAdapter.fragments.clear()
        feedsTabAdapter.titles.clear()

        feedsTabAdapter.titles.add("Deals")
        feedsTabAdapter.titles.add("Events")
        feedsTabAdapter.titles.add("Job Announcements")

        feedsTabAdapter.fragments.add(DealsFragment())
        feedsTabAdapter.fragments.add(EventsFragment())
        feedsTabAdapter.fragments.add(JobsAnnouncementFragment())

        feedsTabAdapter.notifyDataSetChanged()

        root.vpFeeds.adapter = feedsTabAdapter
        root.tabFeeds.setupWithViewPager(root.vpFeeds, true)

        setEvent()

        return root
    }

    private fun setEvent() {
        root.ivSearch.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            root.ivSearch.id -> {
                showBottomSheet()
            }
        }
    }

    private fun showBottomSheet() {
        val addSearchBottomDialogFragment =
            SearchBottomSheetFragment.newInstance()
        addSearchBottomDialogFragment?.from = From.FEED
        addSearchBottomDialogFragment?.isCancelable = false
        addSearchBottomDialogFragment?.show(
            childFragmentManager,
            "search_dialog_fragment"
        )
    }
}
