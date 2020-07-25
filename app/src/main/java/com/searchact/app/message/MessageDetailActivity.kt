package com.searchact.app.message

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.searchact.app.R
import com.searchact.app.main.data.Messages
import com.searchact.app.message.data.Message
import com.searchact.app.message.data.MessagesFixtures
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessageInput
import com.stfalcon.chatkit.messages.MessagesListAdapter
import com.stfalcon.chatkit.messages.MessagesListAdapter.HoldersConfig
import kotlinx.android.synthetic.main.activity_message_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class MessageDetailActivity : AppCompatActivity() {

    private var messages: Messages? = null
    private val senderId = "0"
    private var imageLoader: ImageLoader? = null
    private var messagesAdapter: MessagesListAdapter<Message>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_detail)

        messages = try {
            Gson().fromJson(
                intent?.getStringExtra("message"),
                Messages::class.java
            )
        } catch (ex: Exception) {
            null
        }

        imageLoader = ImageLoader { imageView, url, payload ->
            Glide.with(this).load(R.mipmap.ic_launcher_round).into(imageView)
        }

        setupToolbar()
        setupAdapter()
        setEvent()
    }

    private fun setEvent() {
        msInput.setInputListener(inputListener)
    }

    private val inputListener = MessageInput.InputListener {
        messagesAdapter?.addToStart(MessagesFixtures().getTextMessage(it.toString()), true)
        true
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = messages?.name ?: run { "" }
    }

    private fun setupAdapter() {
        val holdersConfig = HoldersConfig()
        holdersConfig.setIncomingLayout(R.layout.item_custom_incoming_text_message)
        holdersConfig.setOutcomingLayout(R.layout.item_custom_outcoming_message)
        messagesAdapter = MessagesListAdapter(senderId, holdersConfig, imageLoader)
        msList.setAdapter(messagesAdapter)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
