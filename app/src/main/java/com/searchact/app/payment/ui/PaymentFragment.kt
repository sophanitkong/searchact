package com.searchact.app.payment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.searchact.app.R
import com.searchact.app.payment.adapter.PaymentTypeAdapter
import kotlinx.android.synthetic.main.fragment_payment.view.*

/**
 * A simple [Fragment] subclass.
 */
class PaymentFragment : Fragment() {

    private lateinit var root: View
    private lateinit var paymentTypeAdapter: PaymentTypeAdapter
    private lateinit var paymentLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_payment, container, false)

        paymentTypeAdapter = PaymentTypeAdapter(arrayListOf())
        paymentLayoutManager =
            LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)

        root.rcPaymentType.layoutManager = paymentLayoutManager
        root.rcPaymentType.adapter = paymentTypeAdapter

        setupAdapter()

        return root
    }

    private fun setupAdapter() {
        paymentTypeAdapter.types.clear()
        for (index in 0..5) paymentTypeAdapter.types.add("$index")
        paymentTypeAdapter.notifyDataSetChanged()
    }

}
