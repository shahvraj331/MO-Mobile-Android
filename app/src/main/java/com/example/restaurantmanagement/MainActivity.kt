package com.example.restaurantmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv.text = "hello"

        
    }
}