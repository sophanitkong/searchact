package com.searchact.app.main.ui.more

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.deal.mydeal.MyDealActivity
import com.searchact.app.events.myevent.MyEventActivity
import com.searchact.app.followpage.FollowPageActivity
import com.searchact.app.myfriends.MyFriendsActivity
import com.searchact.app.myjobannouncement.MyJobAnnouncementActivity
import com.searchact.app.mylist.MyListActivity
import com.searchact.app.newfeed.NewFeedActivity
import com.searchact.app.profile.ProfileActivity
import com.searchact.app.requestfriend.RequestFriendActivity
import com.searchact.app.settings.SettingsActivity
import kotlinx.android.synthetic.main.fragment_more.view.*

class MoreFragment : Fragment() {

    private lateinit var notificationsViewModel: MoreViewModel
    private lateinit var settingsAdapter: MoreSettingsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(MoreViewModel::class.java)

        settingsAdapter = MoreSettingsAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(container?.context)
        layoutManager.isAutoMeasureEnabled = true

        val root = inflater.inflate(R.layout.fragment_more, container, false)
        val rcSettings: RecyclerView = root.findViewById(R.id.rcSettings)
        notificationsViewModel.settings.observe(viewLifecycleOwner, Observer {
            settingsAdapter.settings = it
            settingsAdapter.notifyDataSetChanged()
        })

        rcSettings.layoutManager = layoutManager
        rcSettings.isNestedScrollingEnabled = false
        rcSettings.adapter = settingsAdapter

        settingsAdapter.listener = object : OnSettingSelectedListener {
            override fun onSettingSelected(position: Int) {
                when (position) {
                    0 -> startActivity(Intent(root.context, NewFeedActivity::class.java))
                    1 -> startActivity(Intent(root.context, MyListActivity::class.java))
                    2 -> startActivity(Intent(root.context, MyFriendsActivity::class.java))
                    3 -> startActivity(Intent(root.context, MyDealActivity::class.java))
                    4 -> startActivity(Intent(root.context, MyEventActivity::class.java))
                    5 -> startActivity(Intent(root.context, MyJobAnnouncementActivity::class.java))
                    6 -> startActivity(Intent(root.context, FollowPageActivity::class.java))
                    7 -> startActivity(Intent(root.context, SettingsActivity::class.java))
                    8 -> Toast.makeText(root.context, "Log Out", Toast.LENGTH_SHORT).show()
                }
            }
        }

        root.llMoreProfile.setOnClickListener {
            startActivity(Intent(root.context, ProfileActivity::class.java))
        }

        return root
    }
}
