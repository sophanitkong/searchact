package com.searchact.app.deal.detail

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.searchact.app.R
import com.searchact.app.deal.require.DealRequirementActivity
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_deal_detail.*

class DealDetailActivity : AppCompatActivity() {

    private var isViewDeal: Boolean? = false

    private lateinit var adapter: DealServiceAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deal_detail)

        isViewDeal = intent?.getBooleanExtra("is_view_deal", false)

        adapter = DealServiceAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcServices.layoutManager = layoutManager
        rcServices.adapter = adapter

        setupToolbar()
        setView()
        setupAdapter()
        setEvent()
    }

    private fun setView() {
        llBottomDeal.visibility = if (isViewDeal!!) View.GONE else View.VISIBLE
    }

    private fun setEvent() {
        btnEditDeal.setOnClickListener(onClicked)
        btnDeleteDeal.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnEditDeal.id -> {
                val intent = Intent(this, DealRequirementActivity::class.java)
                intent.putExtra("is_deal_edited", true)
                startActivity(intent)
            }

            btnDeleteDeal.id -> {
                Core.showDeleteDialog(
                    this,
                    "Delete Deal",
                    "Are you sure you want to delete the deal name : Year End Special Offer Up to 30%?r"
                )
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(anim_toolbar_deal)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        collapsing_toolbar.title = ""

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (collapsing_toolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
                    collapsing_toolbar
                )
            ) {
                anim_toolbar_deal.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar_deal.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_white)
            } else {
                anim_toolbar_deal.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar_deal.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_white)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        adapter.services.clear()
        for (index in 0..1) adapter.services.add("$index")
        adapter.notifyDataSetChanged()
    }
}
