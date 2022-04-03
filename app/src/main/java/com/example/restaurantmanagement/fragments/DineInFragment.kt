package com.example.restaurantmanagement.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restaurantmanagement.databinding.FragmentDineInBinding
import com.example.restaurantmanagement.menulist.MyMenuAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DineInFragment : Fragment() {

    private lateinit var binding: FragmentDineInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDineInBinding.inflate(layoutInflater)
        setTabLayout()
        return binding.root
    }

    private fun setTabLayout() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val title = arrayOf("Menu", "Table")

        viewPager.adapter = MyMenuAdapter(parentFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = title[pos]
        }.attach()
    }

}