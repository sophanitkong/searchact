package com.searchact.app.viewdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.searchact.app.R
import com.searchact.app.viewdetail.AddPhotoBottomDialogFragment
import com.searchact.app.viewdetail.adapter.PhotoAdapter
import kotlinx.android.synthetic.main.fragment_photo.view.*


/**
 * A simple [Fragment] subclass.
 */
class PhotoFragment : Fragment() {

    private lateinit var root: View
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var photoLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_photo, container, false)

        photoAdapter = PhotoAdapter(arrayListOf())
        photoLayoutManager = GridLayoutManager(root.context, 3)

        root.rcPhotos.layoutManager = photoLayoutManager
        root.rcPhotos.adapter = photoAdapter

        setEvent()
        setupAdapter()

        return root
    }

    private fun setEvent() {
        root.llAddPhoto.setOnClickListener(onClicked)
    }

    private val onClicked = View.OnClickListener {
        when (it.id) {
            root.llAddPhoto.id -> {
                showBottomSheet()
            }
        }
    }

    private fun setupAdapter() {
        photoAdapter.photos.clear()
        for (index in 0..11) {
            photoAdapter.photos.add(R.drawable.resturent_fill)
        }
        photoAdapter.notifyDataSetChanged()
    }

    private fun showBottomSheet() {
        val addPhotoBottomDialogFragment =
            AddPhotoBottomDialogFragment.newInstance()
        addPhotoBottomDialogFragment?.show(
            childFragmentManager,
            "add_photo_dialog_fragment"
        )
    }

}
