package com.searchact.app.main.ui.notifications

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.main.data.Notification
import kotlinx.android.synthetic.main.notification_header.view.*
import kotlinx.android.synthetic.main.notification_item.view.*

class NotificationAdapter(
    var notifications: ArrayList<Notification>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    StickHeaderItemDecoration.StickyHeaderInterface {

    private lateinit var _context: Context

    companion object {
        const val HEADER_TYPE = 0
        const val ITEM_TYPE = 1
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        var post = itemPosition
        var headerPosition = 0
        do {
            if (this.isHeader(post)) {
                headerPosition = post
                break
            }
            post -= 1
        } while (post >= 0)
        return headerPosition
    }

    override fun getHeaderLayout(headerPosition: Int): Int {
        return if (notifications[headerPosition].viewType == 0)
            R.layout.notification_header
        else {
            R.layout.notification_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            HEADER_TYPE -> {
                return HeaderViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.notification_header,
                        parent,
                        false
                    )
                )
            }
            ITEM_TYPE -> {
                _context = parent.context
                return NotificationViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.notification_item,
                        parent,
                        false
                    )
                )
            }
            else -> {
                return ProgressViewHolderX(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.load_more_layout,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int = notifications.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NotificationViewHolder -> {
                val notification = notifications[position]
                holder.itemView.apply {
                    this.tvNotificationTitle.text = notification.title
                    this.tvNotificationDateTime.text = notification.dateTime
                    this.tvNotificationShortName.text = "KS"
                }
            }
            is HeaderViewHolder -> {
                holder.itemView.tvHeader.text = notifications[position].stickyTitle
            }
        }
    }

    override fun bindHeaderData(header: View, headerPosition: Int) {
        header.tvHeader.text = notifications[headerPosition].stickyTitle
    }

    override fun isHeader(itemPosition: Int): Boolean {
        return notifications[itemPosition].viewType == 0
    }

    override fun getItemViewType(position: Int): Int {
        return notifications[position].viewType!!
    }

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

        }
    }

    inner class ProgressViewHolderX(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}