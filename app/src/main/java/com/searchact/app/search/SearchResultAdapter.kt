package com.searchact.app.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.main.ui.feeds.From

interface OnItemSearchClickedListener {
    fun onItemClicked()
}

class SearchResultAdapter(var result: ArrayList<String>, var from: From? = From.HOME) :
    RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    var listener: OnItemSearchClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData() {
            view.setOnClickListener { listener?.onItemClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            when (from!!) {
                From.HOME -> LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_search_result, parent, false)
                From.FEED -> LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_my_deal, parent, false)
            }

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData()
    }
}