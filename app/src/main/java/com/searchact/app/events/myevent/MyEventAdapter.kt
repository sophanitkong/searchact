package com.searchact.app.events.myevent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

interface OnItemEventClickedListener {
    fun onItemClicked()
}

class MyEventAdapter(var events: ArrayList<String>) :
    RecyclerView.Adapter<MyEventAdapter.ViewHolder>() {

    var listener: OnItemEventClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData() {
            view.setOnClickListener { listener?.onItemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_my_event, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData()
    }
}