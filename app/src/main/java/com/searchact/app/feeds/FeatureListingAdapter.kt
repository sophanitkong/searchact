package com.searchact.app.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.models.FeatureListing

interface OnItemListingClickedListener {
    fun onViewClicked(feature: FeatureListing)
}

class FeatureListingAdapter(var features: ArrayList<FeatureListing>) :
    RecyclerView.Adapter<FeatureListingAdapter.ViewHolder>() {

    var listener: OnItemListingClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(feature: FeatureListing) {

            view.setOnClickListener {
                listener?.onViewClicked(feature)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_feature_listing, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = features.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(features[position])
    }
}