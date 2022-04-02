package com.example.restaurantmanagement.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.databinding.ActivityTutorialScreen2Binding

class TutorialScreen2 : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_screen2)
        binding = ActivityTutorialScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnNext.setOnClickListener {
            val intent = Intent(applicationContext, TutorialScreen3::class.java)
            startActivity(intent)
        }

        binding.tvSkip.setOnClickListener {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
        }
    }

}