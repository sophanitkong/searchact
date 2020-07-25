package com.searchact.app.payment

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.searchact.app.R
import com.searchact.app.payment.adapter.PaymentPagerAdapter
import com.searchact.app.payment.ui.BillingFragment
import com.searchact.app.payment.ui.ConfirmFragment
import com.searchact.app.payment.ui.PaymentFragment
import com.searchact.app.utils.Core
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.layout_toolbar.*


class PaymentActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: PaymentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        pagerAdapter = PaymentPagerAdapter(arrayListOf(), arrayListOf(), supportFragmentManager)
        vpPayment.adapter = pagerAdapter
        tabPayment.setupWithViewPager(vpPayment)

        setupToolbar()
        setPagerAdapter()
    }

    private fun setPagerAdapter() {
        pagerAdapter.fragments.clear()
        pagerAdapter.titles.clear()

        pagerAdapter.fragments.add(BillingFragment())
        pagerAdapter.fragments.add(PaymentFragment())
        pagerAdapter.fragments.add(ConfirmFragment())

        pagerAdapter.titles.add("Billing")
        pagerAdapter.titles.add("Payment")
        pagerAdapter.titles.add("Confirm")

        pagerAdapter.notifyDataSetChanged()

        setupTab()
    }

    private fun setupTab() {
        tabPayment.getTabAt(0)?.setIcon(R.drawable.bg_billing)
        tabPayment.getTabAt(1)?.setIcon(R.drawable.bg_payment_tab)
        tabPayment.getTabAt(2)?.setIcon(R.drawable.bg_confirm)

        val root: View = tabPayment.getChildAt(0)
        if (root is LinearLayout) {
            root.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
            root.orientation = LinearLayout.HORIZONTAL
            val drawable = GradientDrawable()
            drawable.setColor(ContextCompat.getColor(this, R.color.colorBlack))
            drawable.setSize(5, 5)
            root.dividerPadding = 30
            root.dividerDrawable = drawable
        }

        if (tabPayment.getTabAt(0)?.isSelected!!) {
            btnPayment.text = "Next"
        }

        btnPayment.setOnClickListener {
            tabPayment.getTabAt(1)!!.select()
            if (tabPayment.getTabAt(1)?.isSelected!!) {
                btnPayment.setOnClickListener {
                    tabPayment.getTabAt(2)!!.select()
                    btnPayment.text = "Pay"

//                    btnPayment.setOnClickListener {
//                        Core.showSuccessReportFlagDialog(
//                            this, "Payment Complete", "Thank You! Your payment has been\n" +
//                                    "process successfully!"
//                        )
//                    }

                    btnPayment.setOnClickListener {
                        Core.showSuccessReportFlagDialog(
                            this, "Success", "Thank You! Our team will directly\n" +
                                    "contact you for complete cash\n" +
                                    "payment procedure."
                        ){

                        }
                    }

//                    btnPayment.setOnClickListener {
//                        Core.showFailPayment(
//                            this, "Payment Failed", "Something went wrong, please try again"
//                        )
//                    }

                }
            }
        }
    }

    fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Upgrade Listing"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
