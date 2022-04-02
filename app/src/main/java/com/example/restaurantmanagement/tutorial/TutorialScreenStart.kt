package com.example.restaurantmanagement.tutorial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.databinding.ActivityTutorialScreenStartBinding

class TutorialScreenStart : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreenStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialScreenStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnNext.setOnClickListener {
            val intent = Intent(applicationContext, TutorialScreenMid::class.java)
            startActivity(intent)
        }

        binding.tvSkip.setOnClickListener {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
        }
    }

}