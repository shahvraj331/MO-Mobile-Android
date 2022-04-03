package com.example.restaurantmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmanagement.databinding.FavSingleItemBinding
import com.example.restaurantmanagement.menulist.Food

class MyFavouriteAdapter (private var favList: ArrayList<Food>) :
    RecyclerView.Adapter<MyFavouriteAdapter.ViewHolder>() {

    private lateinit var binding:  FavSingleItemBinding

    inner class ViewHolder(binding: FavSingleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodimage = binding.img
        val foodname = binding.foodTitle
        val foodPrice = binding.foddprice
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        binding = FavSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDetails = favList[position]
        itemDetails.foodImage?.let { holder.foodimage.setImageResource(it) }
        holder.foodname.text = itemDetails.foodName
        holder.foodPrice.text = itemDetails.foodPrice
    }

    override fun getItemCount(): Int {
       return favList.count()
    }

}