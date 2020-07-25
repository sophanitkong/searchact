package com.searchact.app.payment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PaymentPagerAdapter(
    var titles: ArrayList<String>,
    var fragments: ArrayList<Fragment>,
    fm: FragmentManager
) :
    FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}