package com.example.restaurantmanagement.tableBooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restaurantmanagement.databinding.FragmentDineinBinding
import com.google.android.material.tabs.TabLayoutMediator

class DineInFragment : Fragment() {

    private lateinit var binding: FragmentDineinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDineinBinding.inflate(layoutInflater)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val title = arrayOf("Menu", "Table")
        viewPager.adapter = MyMenuAdapter(parentFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = title[pos]
        }.attach()
        return binding.root
    }

}