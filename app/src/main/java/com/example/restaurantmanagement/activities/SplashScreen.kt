package com.example.restaurantmanagement.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantmanagement.databinding.ActivitySplashScreenBinding
import com.example.restaurantmanagement.tutorial.TutorialScreenStart


class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed(Runnable {
            val i = Intent(this, TutorialScreenStart::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}