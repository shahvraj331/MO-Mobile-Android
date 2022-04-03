package com.example.restaurantmanagement.menulist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmanagement.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        val menuRecyclerView = binding.menuRecyclerView
        menuRecyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 2)
        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = MyMenuFragmentAdapter(Data.getMenuData())
        Log.d("Key", menuRecyclerView.toString())
        return binding.root
    }
}