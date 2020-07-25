package com.searchact.app.addlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

class BusinessHourAdapter(var businessHours: ArrayList<String>) :
    RecyclerView.Adapter<BusinessHourAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_business_hour, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = businessHours.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}