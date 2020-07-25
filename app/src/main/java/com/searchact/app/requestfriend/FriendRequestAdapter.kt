package com.searchact.app.requestfriend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import com.searchact.app.models.FriendRequest

class FriendRequestAdapter(var requests: ArrayList<FriendRequest>) :
    RecyclerView.Adapter<FriendRequestAdapter.ViewHolder>() {

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(request: FriendRequest) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_friend_request, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = requests.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(requests[position])
    }


}