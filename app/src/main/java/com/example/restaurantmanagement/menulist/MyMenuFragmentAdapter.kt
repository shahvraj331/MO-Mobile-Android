package com.example.restaurantmanagement.menulist

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.SingleMenuItemBinding

class MyMenuFragmentAdapter(private var foodList: ArrayList<Food>, private var context: Context) :
    RecyclerView.Adapter<MyMenuFragmentAdapter.ViewHolder>() {

    lateinit var binding: SingleMenuItemBinding

    inner class ViewHolder(binding: SingleMenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodimage = binding.img
        val foodname = binding.foodTitle
        val foodPrice = binding.foddprice
        val quantityPlus = binding.btnAdd
        val quantityMinus = binding.btnMinus
        val quantity = binding.txtquantity
        val addFav = binding.btnAddToFav
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDetails = foodList[position]
        itemDetails.foodImage?.let { holder.foodimage.setImageResource(it) }
        holder.foodname.text = itemDetails.foodName
        holder.foodPrice.text = itemDetails.foodPrice
        var quantityValue = 0
        holder.quantityPlus.setOnClickListener {
            quantityValue += 1
            holder.quantity.text = quantityValue.toString()
        }
        holder.quantityMinus.setOnClickListener {
            if (quantityValue > 1) {
                quantityValue -= 1
            }
            holder.quantity.text = quantityValue.toString()
        }
        var flag = 0
        var selected = holder.addFav.isSelected
        Log.d("value", selected.toString())
        holder.addFav.setImageResource(R.drawable.fav_button_unselected)
        holder.addFav.setOnClickListener {
           holder.addFav.animate().apply {
              duration = 1000
               rotationYBy(360f)
            }.start()
            if (flag == 0) {
                holder.addFav.setImageResource(R.drawable.fav_button)
                flag = 1
            } else if (flag == 1) {
                holder.addFav.setImageResource(R.drawable.fav_button_unselected)
                flag = 0
            }
        }
    }

    override fun getItemCount(): Int {
        return foodList.count()
    }

}