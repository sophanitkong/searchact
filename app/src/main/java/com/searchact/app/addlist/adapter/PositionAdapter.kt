package com.searchact.app.addlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_position.view.*

class PositionAdapter(var data: ArrayList<String>) :
    RecyclerView.Adapter<PositionAdapter.ViewHolder>() {

    private var selectedItem = -1

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(position: Int) {

            view.cardViewPosition.setBackgroundResource(R.drawable.bg_white_stroke)
            if (selectedItem == position) {
                view.cardViewPosition.setBackgroundResource(R.drawable.bg_yellow_stroke)
            }

            view.setOnClickListener {

                val previousItem = selectedItem
                selectedItem = position

                notifyItemChanged(previousItem)
                notifyItemChanged(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_position, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(position)
    }

}