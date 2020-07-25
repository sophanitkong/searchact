package com.searchact.app.viewdetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

interface OnItemJobClickedListener {
    fun onItemClicked()
}

class JobAnnouncementAdapter(var jobs: ArrayList<String>) :
    RecyclerView.Adapter<JobAnnouncementAdapter.ViewHolder>() {

    var listener: OnItemJobClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData() {
            view.setOnClickListener { listener?.onItemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_job_announcement, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = jobs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData()
    }
}