package com.searchact.app.viewdetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_rating_review.view.*

class ReviewAdapter(var reviews: ArrayList<String>) :
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var ratingWithPhotoAdapter: RatingWithPhotoAdapter = RatingWithPhotoAdapter(
            arrayListOf()
        )
        private var layoutManager: LinearLayoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        fun setData(review:String){
            view.rcRatingWithPhoto.layoutManager = layoutManager
            view.rcRatingWithPhoto.adapter = ratingWithPhotoAdapter

            setupAdapter()
        }

        private fun setupAdapter(){
            ratingWithPhotoAdapter.photos.clear()
            for (index in 0..10) ratingWithPhotoAdapter.photos.add(R.drawable.resturent_fill)
            ratingWithPhotoAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_rating_review, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = reviews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(reviews[position])
    }
}