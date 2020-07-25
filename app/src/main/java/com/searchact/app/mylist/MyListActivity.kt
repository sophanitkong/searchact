package com.searchact.app.mylist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.addlist.AddListActivity
import com.searchact.app.viewdetail.ViewDetailActivity
import kotlinx.android.synthetic.main.activity_my_list.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MyListActivity : AppCompatActivity() {

    private lateinit var myListAdapter: MyListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list)

        myListAdapter = MyListAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(this)

        rcMyList.layoutManager = layoutManager
        rcMyList.adapter = myListAdapter

        setupToolbar()
        setAdapter()
        setEvent()
    }

    private fun setEvent() {
        btnMyListFloating.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            btnMyListFloating.id -> {
                startActivity(Intent(this, AddListActivity::class.java))
            }
        }
    }

    private fun setAdapter() {
        myListAdapter.mylist.clear()
        for (index in 0..5) myListAdapter.mylist.add("$index")
        myListAdapter.notifyDataSetChanged()

        myListAdapter.listener = object : OnItemClickedListener {
            override fun onItemClicked() {
                val intent = Intent(this@MyListActivity, ViewDetailActivity::class.java)
                intent.putExtra("is_from_mylist", true)
                startActivity(intent)
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "My Listing"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
