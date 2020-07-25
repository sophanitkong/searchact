package com.searchact.app.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.deal.detail.DealDetailActivity
import com.searchact.app.main.ui.feeds.From
import com.searchact.app.viewdetail.ViewDetailActivity
import kotlinx.android.synthetic.main.activity_search_result.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class SearchResultActivity : AppCompatActivity() {

    private var isFrom: From? = From.HOME
    private lateinit var searchResultAdapter: SearchResultAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        isFrom = intent?.getSerializableExtra("is_from") as? From

        searchResultAdapter = SearchResultAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcSearchResult.layoutManager = layoutManager
        rcSearchResult.adapter = searchResultAdapter

        searchResultAdapter.listener = object : OnItemSearchClickedListener {
            override fun onItemClicked() {
                when (isFrom) {
                    From.HOME -> {
                        startActivity(
                            Intent(
                                this@SearchResultActivity,
                                ViewDetailActivity::class.java
                            )
                        )
                    }
                    From.FEED -> {
                        startActivity(
                            Intent(
                                this@SearchResultActivity,
                                DealDetailActivity::class.java
                            )
                        )
                    }
                }
            }
        }

        setupToolbar()
        setupAdapter()
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Search Results"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        searchResultAdapter.result.clear()
        when (isFrom) {
            From.HOME -> searchResultAdapter.from = From.HOME
            From.FEED -> searchResultAdapter.from = From.FEED
        }

        for (index in 0..10) searchResultAdapter.result.add("$index")
        searchResultAdapter.notifyDataSetChanged()
    }
}
