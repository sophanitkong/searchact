package com.searchact.app.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_listing_post.view.*

interface OnItemPostClickedListener {
    fun onItemClicked()
}

class ListingPostAdapter(var post: ArrayList<String>) :
    RecyclerView.Adapter<ListingPostAdapter.ViewHolder>() {

    var listener: OnItemPostClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData() {
            view.llPostContainer.setOnClickListener { listener?.onItemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_listing_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = post.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData()
    }
}