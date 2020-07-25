package com.searchact.app.main.ui.messages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.searchact.app.R
import com.searchact.app.main.data.Messages
import kotlinx.android.synthetic.main.layout_message.view.*

interface OnItemMessageClickedListener {
    fun onItemClicked(messages: Messages)
}

class MessageAdapter(var messages: ArrayList<Messages>) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    var listener: OnItemMessageClickedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(messages: Messages) {
            view.setOnClickListener { listener?.onItemClicked(messages) }

            Glide.with(view.context).load(messages.profile).into(view.ivProfile)
            view.tvMessageName.text = messages.name
            view.tvMessage.text = messages.message
            view.tvOnlineDate.text = messages.date
            if (messages.status) {
                view.viewDot.visibility =
                    View.VISIBLE
                view.tvOnlineDate.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorBlack
                    )
                )
            } else {
                view.viewDot.visibility = View.INVISIBLE
                view.tvOnlineDate.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorLightGray
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_message, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(messages[position])
    }
}