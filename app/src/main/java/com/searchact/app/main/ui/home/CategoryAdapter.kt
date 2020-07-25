package com.searchact.app.main.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.searchact.app.R
import com.searchact.app.main.data.Category
import kotlinx.android.synthetic.main.layout_category.view.*

interface OnCategoryClicked {
    fun onCategoryClicked(category: Category)
}

class CategoryAdapter(var categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onCategoryClicked: OnCategoryClicked? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(category: Category) {
            Glide
                .with(view.context)
                .load(category.image)
                .into(view.ivCategory)
            view.tvCategoryName.text = category.name

            view.setOnClickListener { onCategoryClicked?.onCategoryClicked(category) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(categories[position])
    }
}