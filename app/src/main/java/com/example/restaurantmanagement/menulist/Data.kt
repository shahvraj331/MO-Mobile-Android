package com.example.restaurantmanagement.menulist

import com.example.restaurantmanagement.R

class Data {

    companion object {
        fun getMenuData(): ArrayList<Food> {
            val foodList: ArrayList<Food> = ArrayList()
            for (i in 1..5) {
                foodList.add(Food(R.drawable.food_image, "Spicy Cheese Burger", "$90"))
            }
            return foodList
        }
    }
}