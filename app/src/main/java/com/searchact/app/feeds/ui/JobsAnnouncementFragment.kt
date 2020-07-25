package com.searchact.app.feeds.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.createjobreview.CreatedJobReviewActivity
import com.searchact.app.viewdetail.adapter.JobAnnouncementAdapter
import com.searchact.app.viewdetail.adapter.OnItemJobClickedListener
import kotlinx.android.synthetic.main.fragment_jobs_announcement.view.*

/**
 * A simple [Fragment] subclass.
 */
class JobsAnnouncementFragment : Fragment() {

    private lateinit var root: View
    private lateinit var jobAnnouncementAdapter: JobAnnouncementAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_jobs_announcement, container, false)

        jobAnnouncementAdapter = JobAnnouncementAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(root.context)

        root.rcFeedJobAnnouncement.layoutManager = layoutManager
        root.rcFeedJobAnnouncement.adapter = jobAnnouncementAdapter

        jobAnnouncementAdapter.jobs.clear()
        for (index in 0..10) jobAnnouncementAdapter.jobs.add("$index")
        jobAnnouncementAdapter.notifyDataSetChanged()

        jobAnnouncementAdapter.listener = object : OnItemJobClickedListener {
            override fun onItemClicked() {
                val intent = Intent(root.context, CreatedJobReviewActivity::class.java)
                intent.putExtra("is_new_feed", true)
                startActivity(intent)
            }
        }

        return root
    }

}
