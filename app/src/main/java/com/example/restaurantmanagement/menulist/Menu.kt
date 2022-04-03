package com.example.restaurantmanagement.menulist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantmanagement.databinding.ActivityMenuBinding
import com.google.android.material.tabs.TabLayoutMediator


class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val title = arrayOf("Menu", "Table")

        viewPager.adapter = MyMenuAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = title[pos]
        }.attach()
    }

}