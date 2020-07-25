package com.searchact.app.viewdetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R

class HashTagAdapter(var hastags: ArrayList<String>) :
    RecyclerView.Adapter<HashTagAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(hastag: String) {}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_hashtag, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = hastags.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(hastags[position])
    }
}