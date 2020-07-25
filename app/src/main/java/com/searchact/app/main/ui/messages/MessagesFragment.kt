package com.searchact.app.main.ui.messages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.searchact.app.R
import com.searchact.app.main.data.Messages
import com.searchact.app.message.MessageDetailActivity

class MessagesFragment : Fragment() {

    private lateinit var messagesViewModel: MessagesViewModel
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        messagesViewModel =
            ViewModelProviders.of(this).get(MessagesViewModel::class.java)

        messageAdapter = MessageAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(container?.context)

        val root = inflater.inflate(R.layout.fragment_messages, container, false)
        val rcMessages: RecyclerView = root.findViewById(R.id.rcMessages)
        messagesViewModel.messages.observe(viewLifecycleOwner, Observer {
            messageAdapter.messages = it
            messageAdapter.notifyDataSetChanged()
        })

        rcMessages.layoutManager = layoutManager
        rcMessages.adapter = messageAdapter

        messageAdapter.listener = object : OnItemMessageClickedListener {
            override fun onItemClicked(messages: Messages) {
                val intent = Intent(root.context, MessageDetailActivity::class.java)
                intent.putExtra("message", Gson().toJson(messages ))
                startActivity(intent)
            }
        }

        return root
    }
}
