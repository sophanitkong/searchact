package com.searchact.app.main.ui.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.searchact.app.R
import com.searchact.app.main.data.Messages

class MessagesViewModel : ViewModel() {

    private val _messages = MutableLiveData<ArrayList<Messages>>().apply {
        value = arrayListOf(
            Messages(
                profile = R.drawable.car,
                name = "William Park",
                message = "Thanks you for reviewing our"
            ),
            Messages(
                profile = R.drawable.car,
                name = "William Park",
                message = "Thanks you for reviewing our"
            ),
            Messages(
                profile = R.drawable.car,
                name = "William Park",
                message = "Thanks you for reviewing our"
            ),
            Messages(
                profile = R.drawable.car,
                name = "William Park",
                message = "Thanks you for reviewing our"
            )
        )
    }
    val messages: LiveData<ArrayList<Messages>> = _messages
}