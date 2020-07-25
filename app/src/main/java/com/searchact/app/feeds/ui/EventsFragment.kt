package com.searchact.app.feeds.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.events.detail.EventDetailActivity
import com.searchact.app.events.myevent.MyEventAdapter
import com.searchact.app.events.myevent.OnItemEventClickedListener
import kotlinx.android.synthetic.main.fragment_events.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [EventsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventsFragment : Fragment() {

    private lateinit var root: View
    private lateinit var eventAdapter: MyEventAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_events, container, false)

        eventAdapter = MyEventAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(root.context)

        root.rcEvents.layoutManager = layoutManager
        root.rcEvents.adapter = eventAdapter

        eventAdapter.events.clear()
        for (index in 0..10) eventAdapter.events.add("$index")
        eventAdapter.notifyDataSetChanged()

        eventAdapter.listener = object : OnItemEventClickedListener {
            override fun onItemClicked() {
                val intent = Intent(root.context, EventDetailActivity::class.java)
                intent.putExtra("is_from_feed_event", true)
                startActivity(intent)
            }
        }

        return root
    }
}
