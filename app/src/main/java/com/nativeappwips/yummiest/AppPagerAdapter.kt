package com.nativeappwips.yummiest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter

class AppPagerAdapter( activity: FragmentActivity,
        private val fragments: MutableList<Fragment>) : FragmentStateAdapter(activity) {

    private val fragmentIds = fragments.map { System.nanoTime() }.toMutableList()
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
    override fun getItemId(position: Int): Long = fragmentIds[position]

    fun replaceFragment(position: Int, fragment: Fragment) {
        fragments[position] = fragment
        notifyItemChanged(position)
    }
}