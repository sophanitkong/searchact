package com.searchact.app.deal.require

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.deal.createdeal.CreateDealActivity
import com.searchact.app.deal.detail.DealServiceAdapter
import com.searchact.app.deal.mydeal.MyDealActivity
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_requirement_deal.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class DealRequirementActivity : AppCompatActivity() {

    private var isDealEdited: Boolean? = false
    private lateinit var dealServiceAdapter: DealServiceAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requirement_deal)

        dealServiceAdapter = DealServiceAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcEditedServices.layoutManager = layoutManager
        rcEditedServices.adapter = dealServiceAdapter

        isDealEdited = intent?.getBooleanExtra("is_deal_edited", false)

        setupToolbar()
        setView()
        setEvent()
        setupSpinner()
        setupAdapter()
    }

    private fun setEvent() {
        btnEditNext.setOnClickListener(onClicked)
        tvChangeListDeal.setOnClickListener(onClicked)
        etExpireDate.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnEditNext.id -> {
                startActivity(Intent(this, MyDealActivity::class.java))
            }

            tvChangeListDeal.id -> {
                val intent = Intent(this, CreateDealActivity::class.java)
                intent.putExtra("is_changed_list", true)
                startActivity(intent)
            }

            etExpireDate.id -> {
                Core.showDatePicker(this)
            }
        }
    }

    private fun setupSpinner() {
        val plants = arrayOf(
            "Country*",
            "Country 1",
            "Country 2",
            "Country 3",
            "Country 4",
            "Country 5"
        )

        val spinnerArrayAdapter = ArrayAdapter(
            this, R.layout.spinner_item, plants
        )

        spinnerCountry.setSelection(0)
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerCountry.adapter = spinnerArrayAdapter
    }

    private fun setView() {
        tvChangeListDeal.visibility = if (isDealEdited!!) View.VISIBLE else View.GONE
        cardImageAttach.visibility = if (isDealEdited!!) View.VISIBLE else View.GONE
        llEditedServices.visibility = if (isDealEdited!!) View.VISIBLE else View.GONE
        btnEditNext.text = if (isDealEdited!!) "Save" else "Next"
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = if (isDealEdited!!) "Edit Deal" else "Create Deal"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupAdapter() {
        dealServiceAdapter.services.clear()
        for (index in 0..2) dealServiceAdapter.services.add("$index")
        dealServiceAdapter.notifyDataSetChanged()
    }
}
