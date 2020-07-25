package com.searchact.app.payment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_payment_type.view.*

class PaymentTypeAdapter(var types: ArrayList<String>) :
    RecyclerView.Adapter<PaymentTypeAdapter.ViewHolder>() {

    private var selectedItem = -1

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(position: Int) {
            view.cardViewPayment.setBackgroundResource(R.drawable.bg_stroke_gray)
            if (selectedItem == position) {
                view.cardViewPayment.setBackgroundResource(R.drawable.bg_yellow_stroke)
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
            LayoutInflater.from(parent.context).inflate(R.layout.layout_payment_type, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = types.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(position)
    }


}