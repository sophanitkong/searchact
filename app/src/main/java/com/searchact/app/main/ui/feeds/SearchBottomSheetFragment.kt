package com.searchact.app.main.ui.feeds

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.searchact.app.R
import com.searchact.app.search.SearchResultActivity
import kotlinx.android.synthetic.main.layout_search_bottom_sheet.view.*

enum class From {
    HOME, FEED
}

class SearchBottomSheetFragment(var from: From? = From.HOME) : BottomSheetDialogFragment() {
    companion object {
        var instance: SearchBottomSheetFragment? = null
        fun newInstance(): SearchBottomSheetFragment? {
            return if (instance != null) {
                instance
            } else {
                SearchBottomSheetFragment()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_search_bottom_sheet, container, false)
        view.ivClose.setOnClickListener {
            dismiss()
        }

        view.btnBottomSheetSearch.setOnClickListener {
            dismiss()
            val intent = Intent(view.context, SearchResultActivity::class.java)
            intent.putExtra("is_from", from)
            startActivity(intent)
        }
        return view
    }
}