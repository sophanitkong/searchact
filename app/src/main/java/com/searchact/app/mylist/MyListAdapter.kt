package com.searchact.app.mylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

interface OnItemClickedListener {
    fun onItemClicked()
}

class MyListAdapter(var mylist: ArrayList<String>) :
    RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    var listener: OnItemClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData() {
            view.setOnClickListener { listener?.onItemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_mylist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mylist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData()
    }
}