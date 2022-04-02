package com.example.restaurantmanagement.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.databinding.ActivityTutorialScreen4Binding

class TutorialScreen4 : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreen4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialScreen4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
        }
    }

}