package com.searchact.app.deal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

class DealCategoryAdapter(var deals: ArrayList<String>) :
    RecyclerView.Adapter<DealCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_job_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = deals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}