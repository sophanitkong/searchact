package com.searchact.app.viewdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.searchact.app.R
import kotlinx.android.synthetic.main.layout_photo_bottom_sheet.view.*

class AddPhotoBottomDialogFragment : BottomSheetDialogFragment() {
    companion object {
        var instance: AddPhotoBottomDialogFragment? = null
        fun newInstance(): AddPhotoBottomDialogFragment? {
            return if (instance != null) {
                instance
            } else {
                AddPhotoBottomDialogFragment()
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
        val view = inflater.inflate(R.layout.layout_photo_bottom_sheet, container, false)
        view.bottomSheetCancel.setOnClickListener {
            dismiss()
        }
        view.tvChoosePhoto.setOnClickListener {
            dismiss()
        }
        view.tvTakePhoto.setOnClickListener {
            dismiss()
        }
        return view
    }
}