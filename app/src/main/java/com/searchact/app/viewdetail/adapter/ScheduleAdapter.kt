package com.searchact.app.viewdetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.viewdetail.data.Schedule
import kotlinx.android.synthetic.main.layout_schedule.view.*

class ScheduleAdapter(var schedules: ArrayList<Schedule>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(schedule: Schedule) {
            view.tvScheduleDay.text = schedule.day
            view.tvScheduleHours.text = schedule.hours
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_schedule, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(schedules[position])
    }

    override fun getItemCount(): Int = schedules.size
}