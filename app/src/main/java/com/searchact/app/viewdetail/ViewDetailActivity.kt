package com.searchact.app.viewdetail

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.searchact.app.R
import com.searchact.app.claim.ClaimActivity
import com.searchact.app.reportflag.ReportFlagActivity
import com.searchact.app.viewdetail.adapter.HashTagAdapter
import com.searchact.app.viewdetail.adapter.ViewDetailTabAdapter
import com.searchact.app.viewdetail.ui.EmploymentFragment
import com.searchact.app.viewdetail.ui.OverViewFragment
import com.searchact.app.viewdetail.ui.PhotoFragment
import com.searchact.app.viewdetail.ui.ReviewsFragment
import kotlinx.android.synthetic.main.activity_view_detail.*


class ViewDetailActivity : AppCompatActivity() {

    private lateinit var hashTagAdapter: HashTagAdapter
    private lateinit var hashLayoutManager: LinearLayoutManager

    private lateinit var viewDetailPagerAdapter: ViewDetailTabAdapter

    private var isFromMyList: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_detail)

        isFromMyList = intent?.getBooleanExtra("is_from_mylist", false)

        hashLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        hashTagAdapter =
            HashTagAdapter(arrayListOf())

        rcHashtag.layoutManager = hashLayoutManager
        rcHashtag.adapter = hashTagAdapter

        viewDetailPagerAdapter =
            ViewDetailTabAdapter(
                arrayListOf(),
                arrayListOf(),
                supportFragmentManager
            )
        vpViewDetail.adapter = viewDetailPagerAdapter

        setupToolbar()
        setView()
        setEvent()
        setupHashTagAdapter()
        setupTabLayoutWithViewPager()
    }

    private fun setView() {
        btnBookmark.visibility = if (isFromMyList!!) View.GONE else View.VISIBLE
    }

    private fun setupToolbar() {
        setSupportActionBar(anim_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
        collapsing_toolbar.title = ""

        appbar.addOnOffsetChangedListener(OnOffsetChangedListener { _, verticalOffset ->
            if (collapsing_toolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
                    collapsing_toolbar
                )
            ) {
                anim_toolbar.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_white)
            } else {
                anim_toolbar.navigationIcon?.setColorFilter(
                    ContextCompat.getColor(this, android.R.color.white),
                    PorterDuff.Mode.SRC_ATOP
                )
                anim_toolbar.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_white)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setEvent() {
        btnReportFlag.setOnClickListener(onClicked)
        btnClaimListing.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnReportFlag.id -> {
                startActivity(Intent(this@ViewDetailActivity, ReportFlagActivity::class.java))
            }

            btnClaimListing.id -> {
                startActivity(Intent(this@ViewDetailActivity, ClaimActivity::class.java))
            }
        }
    }

    private fun setupHashTagAdapter() {
        hashTagAdapter.hastags.clear()
        for (index in 0..10) {
            hashTagAdapter.hastags.add("$index")
        }
        hashTagAdapter.notifyDataSetChanged()
    }

    private fun setupTabLayoutWithViewPager() {
        viewDetailPagerAdapter.fragments.clear()
        viewDetailPagerAdapter.titles.clear()

        viewDetailPagerAdapter.titles.add("Overview")
        viewDetailPagerAdapter.titles.add("Photos")
        viewDetailPagerAdapter.titles.add("Reviews")
        viewDetailPagerAdapter.titles.add("Employment Opportunities")

        viewDetailPagerAdapter.fragments.add(OverViewFragment())
        viewDetailPagerAdapter.fragments.add(PhotoFragment())
        viewDetailPagerAdapter.fragments.add(ReviewsFragment())
        viewDetailPagerAdapter.fragments.add(EmploymentFragment())

        viewDetailPagerAdapter.notifyDataSetChanged()

        tabViewDetail.setupWithViewPager(vpViewDetail, true)
    }
}
