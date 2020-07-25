package com.searchact.app.deal.createdeal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.deal.adapter.DealCategoryAdapter
import com.searchact.app.deal.require.DealRequirementActivity
import kotlinx.android.synthetic.main.activity_create_deal.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CreateDealActivity : AppCompatActivity() {

    private lateinit var adapter: DealCategoryAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var isChangedList: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_deal)

        isChangedList = intent?.getBooleanExtra("is_changed_list", false)

        adapter = DealCategoryAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcCreateDeal.layoutManager = layoutManager
        rcCreateDeal.adapter = adapter

        setupToolbar()
        setView()
        setupAdapter()
        setEvent()
    }

    private fun setView() {
        btnCreateDealNext.text = if (isChangedList!!) "Change" else "Next"
    }

    private fun setEvent() {
        btnCreateDealNext.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnCreateDealNext.id -> {
                startActivity(Intent(this, DealRequirementActivity::class.java))
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = if (isChangedList!!) "Change List" else "Create Deal"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        adapter.deals.clear()
        for (index in 0..2) adapter.deals.add("$index")
        adapter.notifyDataSetChanged()
    }
}
