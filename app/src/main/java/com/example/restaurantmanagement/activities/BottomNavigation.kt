package com.example.restaurantmanagement.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityBottomNavigationBinding

class BottomNavigation : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationBind()
    }
    private fun bottomNavigationBind() {
//        val navController= findNavController(R.id.navFragment)
//        binding.bnJetpack.setupWithNavController(navController)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navFragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        binding.bnJetpack.setupWithNavController(navController)
    }
}