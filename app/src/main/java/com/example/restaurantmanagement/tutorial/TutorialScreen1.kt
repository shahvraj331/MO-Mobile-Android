package com.example.restaurantmanagement.tutorial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.databinding.ActivityTutorialScreen1Binding

class TutorialScreen1 : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnNext.setOnClickListener {
            val i = Intent(applicationContext, TutorialScreen2::class.java)
            startActivity(i)
        }

        binding.tvSkip.setOnClickListener {
            val i = Intent(applicationContext, Login::class.java)
            startActivity(i)
        }
    }

}