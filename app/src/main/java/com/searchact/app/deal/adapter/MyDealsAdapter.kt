package com.searchact.app.deal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

interface OnItemDealClickedListener {
    fun onItemClicked()
}

class MyDealsAdapter(var deals: ArrayList<String>) :
    RecyclerView.Adapter<MyDealsAdapter.ViewHolder>() {

    var listener: OnItemDealClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData() {
            view.setOnClickListener { listener?.onItemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_my_deal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = deals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData()
    }
}