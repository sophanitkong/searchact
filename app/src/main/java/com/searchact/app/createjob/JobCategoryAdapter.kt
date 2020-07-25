package com.searchact.app.createjob

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_job_category.view.*

interface OnJobCategorySelected {
    fun onSelected()
}

class JobCategoryAdapter(var jobCategories: ArrayList<String>) :
    RecyclerView.Adapter<JobCategoryAdapter.ViewHolder>() {

    var onJobCategorySelected: OnJobCategorySelected? = null
    private var selectedItem = -1

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(position: Int) {

            view.llJobContainer.setBackgroundResource(R.drawable.bg_stroke_gray)
            if (selectedItem == position) {
                view.llJobContainer.setBackgroundResource(R.drawable.bg_yellow_stroke)
            }

            view.setOnClickListener {

                val previousItem = selectedItem
                selectedItem = position

                notifyItemChanged(previousItem)
                notifyItemChanged(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_job_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = jobCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(position)
    }
}