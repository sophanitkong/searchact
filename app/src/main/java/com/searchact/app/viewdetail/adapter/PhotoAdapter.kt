package com.searchact.app.viewdetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_photo.view.*

class PhotoAdapter(var photos: ArrayList<Int>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(photo: Int) {
            Glide.with(view.context).load(photo).into(view.ivPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_photo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(photos[position])
    }
}