package com.searchact.app.main.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchact.app.R
import com.searchact.app.main.data.Notification
import java.util.*
import kotlin.collections.ArrayList

class NotificationsViewModel : ViewModel() {

    private val _notifications = MutableLiveData<TreeMap<String, ArrayList<Notification>>>().apply {
        val hashResult =
            TreeMap<String, ArrayList<Notification>>(
                reverseOrder()
            )
        val tempData: ArrayList<Notification> = arrayListOf(
            Notification(
                title = "The Little Kitchen post a new deal : Hey,\n" +
                        "Enjoy 300% off only today!",
                dateTime = "21 Jul 2019 at 8:00AM",
                stickyTitle = "Today"
            ),
            Notification(
                title = "The Little Kitchen post a new deal : Hey,\n" +
                        "Enjoy 300% off only today!",
                dateTime = "21 Jul 2019 at 8:00AM",
                stickyTitle = "Today"
            ),
            Notification(
                title = "The Little Kitchen post a new deal : Hey,\n" +
                        "Enjoy 300% off only today!",
                dateTime = "21 Jul 2019 at 8:00AM",
                stickyTitle = "Today"
            ),
            Notification(
                title = "The Little Kitchen post a new deal : Hey,\n" +
                        "Enjoy 300% off only today!",
                dateTime = "21 Jul 2019 at 8:00AM",
                stickyTitle = "This Month"
            ),
            Notification(
                title = "The Little Kitchen post a new deal : Hey,\n" +
                        "Enjoy 300% off only today!",
                dateTime = "21 Jul 2019 at 8:00AM",
                stickyTitle = "This Month"
            )
        )

        tempData.forEach {
            val model =
                it.apply { viewType = 1 }
            val key = model.stickyTitle
            if (!hashResult.containsKey(key)) {
                hashResult[key!!] = arrayListOf()
            }
            hashResult[key]?.add(model)
        }
        value = hashResult
    }
    val notifications: LiveData<TreeMap<String, ArrayList<Notification>>> = _notifications
}