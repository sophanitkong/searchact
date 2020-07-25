package com.searchact.app.addlist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.searchact.app.R
import com.searchact.app.addlist.adapter.BusinessHourAdapter
import com.searchact.app.addlist.adapter.ListCategoryAdapter
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_add_list.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class AddListActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var listCategoryAdapter: ListCategoryAdapter
    private lateinit var listCategoryLayoutManager: GridLayoutManager

    private lateinit var businessHourAdapter: BusinessHourAdapter
    private lateinit var businessHourLayoutManager: LinearLayoutManager

    override fun onMapReady(p0: GoogleMap?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list)

        listCategoryAdapter =
            ListCategoryAdapter(arrayListOf())
        listCategoryLayoutManager = GridLayoutManager(this, 3)

        rcListCategory.layoutManager = listCategoryLayoutManager
        rcListCategory.adapter = listCategoryAdapter

        businessHourAdapter =
            BusinessHourAdapter(arrayListOf())
        businessHourLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rcBusinessHour.layoutManager = businessHourLayoutManager
        rcBusinessHour.adapter = businessHourAdapter

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.addListMaps) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        setupToolbar()
        setupListCategoryAdapter()
        setEvent()
        setupBusinessHourAdapter()
    }

    private fun setupBusinessHourAdapter() {
        businessHourAdapter.businessHours.clear()
        for (index in 0..5) businessHourAdapter.businessHours.add("")
        businessHourAdapter.notifyDataSetChanged()
    }

    private fun setEvent() {
        etBusinessHour.setOnClickListener(onClicked)
        llPinMaps.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            etBusinessHour.id -> {
                Core.showTimePicker(this)
            }

            llPinMaps.id -> {
                startActivity(Intent(this, PinMapsActivity::class.java))
            }
        }
    }

    private fun setupListCategoryAdapter() {
        listCategoryAdapter.categories.clear()
        for (index in 0..5) listCategoryAdapter.categories.add("$index")
        listCategoryAdapter.notifyDataSetChanged()
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Add Listing"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
