package com.searchact.app.main.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.main.data.Notification
import com.searchact.app.requestfriend.RequestFriendActivity
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import java.util.*
import kotlin.collections.ArrayList

class NotificationsFragment : Fragment() {

    private lateinit var root: View
    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var tempData = TreeMap<String, ArrayList<Notification>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        notificationAdapter = NotificationAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(container?.context)

        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val rcNotifications: RecyclerView = root.findViewById(R.id.rcNotifications)
        notificationsViewModel.notifications.observe(viewLifecycleOwner, Observer {
            val tempList = ArrayList<Notification>()
            for ((k, _) in it) {
                if (tempData.isNotEmpty()) {
                    val tmp = tempData[k]
                    if (tmp == null) {
                        tempList.add(Notification().apply {
                            viewType = 0; stickyTitle = k
                        })
                    }
                } else {
                    tempList.add(Notification().apply {
                        viewType = 0; stickyTitle = k
                    })
                }
                tempList.addAll(it[k]!!)
            }

            notificationAdapter.notifications = tempList
            notificationAdapter.notifyDataSetChanged()

            tempData = it
        })

        rcNotifications.layoutManager = layoutManager
        rcNotifications.adapter = notificationAdapter

        setupEvent()

        return root
    }

    private fun setupEvent() {
        root.llRequestFriend.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            root.llRequestFriend.id -> {
                startActivity(Intent(root.context, RequestFriendActivity::class.java))
            }
        }
    }
}
