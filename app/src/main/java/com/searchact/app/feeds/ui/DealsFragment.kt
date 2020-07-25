package com.searchact.app.feeds.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.deal.adapter.MyDealsAdapter
import com.searchact.app.deal.adapter.OnItemDealClickedListener
import com.searchact.app.deal.detail.DealDetailActivity
import kotlinx.android.synthetic.main.fragment_deals.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [DealsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DealsFragment : Fragment() {

    private lateinit var root: View
    private lateinit var dealsAdapter: MyDealsAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_deals, container, false)

        dealsAdapter = MyDealsAdapter(arrayListOf())
        layoutManager = LinearLayoutManager(root.context)

        root.rcDeal.layoutManager = layoutManager
        root.rcDeal.adapter = dealsAdapter

        dealsAdapter.deals.clear()
        for (index in 0..10) dealsAdapter.deals.add("$index")
        dealsAdapter.notifyDataSetChanged()

        dealsAdapter.listener = object : OnItemDealClickedListener {
            override fun onItemClicked() {
                val intent = Intent(root.context, DealDetailActivity::class.java)
                intent.putExtra("is_view_deal", true)
                startActivity(intent)
            }
        }

        return root
    }
}
