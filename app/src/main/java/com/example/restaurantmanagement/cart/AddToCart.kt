package com.example.restaurantmanagement.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.FragmentAddToCartBinding

class AddToCart : Fragment() {
    private lateinit var binding: FragmentAddToCartBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val data = ArrayList<CartDataClass>()
        binding = FragmentAddToCartBinding.inflate(layoutInflater)
        val menuRecyclerView = binding.recyclerview
        val arrayList: ArrayList<String> = ArrayList<String>(5)

        data.add(CartDataClass(R.drawable.burger_cart_image, "Spicy chese burger", "$5.09"))
        data.add(CartDataClass(R.drawable.pizza_cart_image, "Maxican Cheese pizza", "$09.99"))
        data.add(CartDataClass(R.drawable.burger_cart_image, "Spicy chese burger", "$5.09"))
        data.add(CartDataClass(R.drawable.pizza_cart_image, "Maxican Cheese pizza", "$09.99"))
        data.add(CartDataClass(R.drawable.burger_cart_image, "Spicy chese burger", "$5.09"))
        data.add(CartDataClass(R.drawable.pizza_cart_image, "Maxican Cheese pizza", "$09.99"))
        data.add(CartDataClass(R.drawable.burger_cart_image, "Spicy chese burger", "$5.09"))
        data.add(CartDataClass(R.drawable.pizza_cart_image, "Maxican Cheese pizza", "$09.99"))
        data.add(CartDataClass(R.drawable.burger_cart_image, "Spicy chese burger", "$5.09"))
        data.add(CartDataClass(R.drawable.pizza_cart_image, "Maxican Cheese pizza", "$09.99"))

        menuRecyclerView.setHasFixedSize(true)
        val layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = MyMenuFragmentAdapter(data)
        return binding.root
    }

}