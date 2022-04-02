package com.example.restaurantmanagement.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.databinding.ActivityTutorialScreen3Binding

class TutorialScreen3 : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreen3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnNext.setOnClickListener {
            val i = Intent(applicationContext, TutorialScreen4::class.java)
            startActivity(i)
        }

        binding.tvSkip.setOnClickListener {
            val i = Intent(applicationContext, Login::class.java)
            startActivity(i)
        }
    }

}