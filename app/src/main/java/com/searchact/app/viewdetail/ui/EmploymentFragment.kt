package com.searchact.app.viewdetail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.searchact.app.R
import com.searchact.app.viewdetail.adapter.JobAnnouncementAdapter
import kotlinx.android.synthetic.main.fragment_employment.view.*

/**
 * A simple [Fragment] subclass.
 */
class EmploymentFragment : Fragment() {

    private lateinit var root: View
    private lateinit var jobAnnouncementAdapter: JobAnnouncementAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_employment, container, false)

        jobAnnouncementAdapter = JobAnnouncementAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(root.context)

        root.rcJobAnnouncement.layoutManager = layoutManager
        root.rcJobAnnouncement.adapter = jobAnnouncementAdapter

        setupAdapter()
        return root
    }

    private fun setupAdapter() {
        jobAnnouncementAdapter.jobs.clear()
        for (index in 0..10) jobAnnouncementAdapter.jobs.add("$index")
        jobAnnouncementAdapter.notifyDataSetChanged()
    }

}
