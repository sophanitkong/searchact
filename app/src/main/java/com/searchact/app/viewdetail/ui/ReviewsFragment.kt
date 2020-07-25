package com.searchact.app.viewdetail.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.ratebussiness.RateBusinessActivity
import com.searchact.app.review.ReviewBusinessActivity
import com.searchact.app.viewdetail.adapter.ReviewAdapter
import kotlinx.android.synthetic.main.fragment_reviews.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewsFragment : Fragment() {

    private lateinit var root: View
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_reviews, container, false)

        reviewAdapter = ReviewAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(root.context)

        root.rcReviews.layoutManager = layoutManager
        root.rcReviews.adapter = reviewAdapter

        setupAdapter()
        setEvent()

        return root
    }

    private fun setEvent() {
        root.llRating.setOnClickListener(onClicked)
        root.llReviewBusiness.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            root.llRating.id -> {
                startActivity(Intent(root.context, RateBusinessActivity::class.java))
            }

            root.llReviewBusiness.id ->{
                startActivity(Intent(root.context, ReviewBusinessActivity::class.java))
            }
        }
    }

    private fun setupAdapter() {
        reviewAdapter.reviews.clear()
        for (index in 0..10) reviewAdapter.reviews.add("$index")
        reviewAdapter.notifyDataSetChanged()
    }
}
