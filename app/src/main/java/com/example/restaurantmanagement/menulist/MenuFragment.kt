package com.example.restaurantmanagement.menulist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.restaurantmanagement.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val menuRecyclerView = binding.menuRecyclerView
        menuRecyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 2)
        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = context?.let { MyMenuFragmentAdapter(Data.getMenuData(), it) }
    }

}