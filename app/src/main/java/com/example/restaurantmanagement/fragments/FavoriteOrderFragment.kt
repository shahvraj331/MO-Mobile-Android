package com.example.restaurantmanagement.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.restaurantmanagement.adapters.MyFavouriteAdapter
import com.example.restaurantmanagement.databinding.FragmentFavoriteOrderBinding
import com.example.restaurantmanagement.menulist.Data

class FavoriteOrderFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =  FragmentFavoriteOrderBinding.inflate(layoutInflater)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val favRecyclerView = binding.favRecyclerView
        favRecyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 2)
        favRecyclerView.layoutManager = layoutManager
        favRecyclerView.adapter = MyFavouriteAdapter(Data.getMenuData())
        Log.d("Key", favRecyclerView.toString())
    }

}