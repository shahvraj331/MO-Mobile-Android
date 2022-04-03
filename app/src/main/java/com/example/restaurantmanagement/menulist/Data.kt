package com.example.restaurantmanagement.menulist

import com.example.restaurantmanagement.R

class Data {

    companion object {
        fun getMenuData(): ArrayList<Food> {
            val foodList: ArrayList<Food> = ArrayList()
            foodList.add(Food(R.drawable.food_image, "Spicy Cheese Burger", "$90"))
            foodList.add(Food(R.drawable.food_one, "Pizza", "$90"))
            foodList.add(Food(R.drawable.food_two, "Donuts", "$90"))
            foodList.add(Food(R.drawable.food_three, "Mayoneese Burger", "$90"))
            foodList.add(Food(R.drawable.food_four, "Curry", "$90"))
            foodList.add(Food(R.drawable.food_image, "Cheese Burger", "$90"))
            return foodList
        }
    }
}