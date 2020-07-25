package com.searchact.app.deal.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

class DealServiceAdapter(var services: ArrayList<String>) :
    RecyclerView.Adapter<DealServiceAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_service, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = services.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}