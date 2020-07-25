package com.searchact.app.main.ui.more

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.searchact.app.R
import com.searchact.app.main.data.Settings
import kotlinx.android.synthetic.main.layout_more_setttings.view.*

interface OnSettingSelectedListener {
    fun onSettingSelected(position: Int)
}

class MoreSettingsAdapter(var settings: ArrayList<Settings>) :
    RecyclerView.Adapter<MoreSettingsAdapter.ViewHolder>() {

    var listener: OnSettingSelectedListener? = null

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(setting: Settings) {

            view.setOnClickListener { listener?.onSettingSelected(adapterPosition) }

            Glide.with(view.context).load(setting.icon).into(view.ivSetting)
            view.tvSettingTitle.text = setting.title
            view.tvSubTitle.text = setting.subTitle
            if (!setting.hasSubTitle) {
                view.tvSubTitle.visibility = View.GONE
            }
            if (setting.isLogout) {
                view.tvSubTitle.visibility = View.GONE
                view.tvSettingTitle.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorReddish
                    )
                )
                view.ivSetting.setBackgroundResource(R.drawable.bg_logout_light_reddis)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_more_setttings, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = settings.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(settings[position])
    }
}