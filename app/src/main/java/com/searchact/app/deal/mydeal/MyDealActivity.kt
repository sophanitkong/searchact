package com.searchact.app.deal.mydeal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.deal.adapter.MyDealsAdapter
import com.searchact.app.deal.adapter.OnItemDealClickedListener
import com.searchact.app.deal.createdeal.CreateDealActivity
import com.searchact.app.deal.detail.DealDetailActivity
import kotlinx.android.synthetic.main.activity_my_deal.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MyDealActivity : AppCompatActivity() {

    private lateinit var adapter: MyDealsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_deal)

        adapter = MyDealsAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcMyDeals.layoutManager = layoutManager
        rcMyDeals.adapter = adapter

        setupToolbar()
        setupAdapter()
        setEvent()
    }

    private fun setEvent() {
        btnDealFloating.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnDealFloating.id -> {
                startActivity(Intent(this, CreateDealActivity::class.java))
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "My Deals"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        adapter.deals.clear()
        for (index in 0..10) adapter.deals.add("$index")
        adapter.notifyDataSetChanged()

        adapter.listener = object : OnItemDealClickedListener {
            override fun onItemClicked() {
                startActivity(Intent(this@MyDealActivity, DealDetailActivity::class.java))
            }
        }
    }
}
