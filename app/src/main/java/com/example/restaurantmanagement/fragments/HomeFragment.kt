package com.example.restaurantmanagement.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantmanagement.HomeData
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.adapters.HomePopularFragmentAdapter
import com.example.restaurantmanagement.adapters.HomeSpecialFragmentAdapter
import com.example.restaurantmanagement.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var items : ArrayList<HomeData>
    private lateinit var offers : ArrayList<HomeData>
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        customRecyclerView()
        viewAllClick()
        val view = binding.root
        return view
    }

    private fun viewAllClick() {
        binding.btnViewAllPopularFoods.setOnClickListener() {
            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
        }

        binding.btnViewAllSpecialOffer.setOnClickListener() {
            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
        }
    }

    private fun customRecyclerView() {
        items = arrayListOf(
            HomeData(title = "title1", image = R.drawable.burger),
            HomeData(title = "title2", image = R.drawable.burger),
            HomeData(title = "title3", image = R.drawable.burger),
            HomeData(title = "title2", image = R.drawable.burger),
            HomeData(title = "title2", image = R.drawable.burger),
            HomeData(title = "title2", image = R.drawable.burger))

        offers = arrayListOf(
            HomeData(image = R.drawable.burger, offer = "30% OFF"),
            HomeData(image = R.drawable.burger, offer = "60% OFF"),
            HomeData(image = R.drawable.burger, offer = "23% OFF"),
            HomeData(image = R.drawable.burger, offer = "36% OFF"),
            HomeData(image = R.drawable.burger, offer = "40% OFF"),
            HomeData(image = R.drawable.burger, offer = "50% OFF"))

        val adapter = HomePopularFragmentAdapter(items)
        val linearLayoutPopularFoods = LinearLayoutManager(requireContext())
        val adapterSpecialOffer = HomeSpecialFragmentAdapter(offers)
        val linearLayoutSpecialOffer = LinearLayoutManager(requireContext())

        linearLayoutPopularFoods.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvPopularItem.layoutManager = linearLayoutPopularFoods
        binding.rvPopularItem.adapter = adapter

        linearLayoutSpecialOffer.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvSpecialOffer.layoutManager = linearLayoutSpecialOffer
        binding.rvSpecialOffer.adapter = adapterSpecialOffer
    }
}