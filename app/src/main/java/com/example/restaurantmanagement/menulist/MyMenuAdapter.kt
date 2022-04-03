package com.example.restaurantmanagement.menulist

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyMenuAdapter(
    fragment: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragment, lifecycle) {

    private val title = arrayOf("Menu", "Table")

    override fun getItemCount(): Int {
        return title.size
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return MenuFragment()
            1 -> return TableFragment()
        }
        return MenuFragment()
    }

}