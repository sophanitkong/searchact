package com.searchact.app.viewdetail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.searchact.app.R
import com.searchact.app.viewdetail.adapter.ScheduleAdapter
import com.searchact.app.viewdetail.data.Schedule
import kotlinx.android.synthetic.main.fragment_over_view.*
import kotlinx.android.synthetic.main.fragment_over_view.view.*

/**
 * A simple [Fragment] subclass.
 */
class OverViewFragment : Fragment(), OnMapReadyCallback {

    private lateinit var root: View
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var googleMap: GoogleMap

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_over_view, container, false)

        scheduleAdapter = ScheduleAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(root.context)

        root.rcSchedule.layoutManager = layoutManager
        root.rcSchedule.adapter = scheduleAdapter

        setupAdapter()

        return root
    }

    private fun setupAdapter() {
        scheduleAdapter.schedules.clear()
        for (index in 0..7) {
            scheduleAdapter.schedules.add(Schedule(day = "Mon", hours = "12:00pm - 10:00pm"))
        }
        scheduleAdapter.notifyDataSetChanged()
    }

}
