package com.example.restaurantmanagement.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmanagement.databinding.CartItemsBinding

class MyMenuFragmentAdapter(private var foodList: ArrayList<CartDataClass>) :
    RecyclerView.Adapter<MyMenuFragmentAdapter.ViewHolder>() {

    lateinit var binding: CartItemsBinding

    inner class ViewHolder(binding: CartItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodName = binding.tvFoodName
        val foodPrice = binding.tvFoodTotalPrice
        val quantityPlus = binding.btnAdd
        val quantityMinus = binding.btnMinus
        val quantity = binding.txtQuantity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CartItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDetails = foodList[position]
        holder.foodName.text = itemDetails.foodName
        holder.foodPrice.text = itemDetails.price
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
    }

    override fun getItemCount(): Int {
        return foodList.count()
    }

}

