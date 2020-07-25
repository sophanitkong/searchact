package com.searchact.app.main.ui.feeds

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FeedsTabAdapter(
    var fragments: ArrayList<Fragment>,
    var titles: ArrayList<String>,
    fm: FragmentManager
): FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}