package com.example.restaurantmanagement.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityTutorialScreenMidBinding

class TutorialScreenMid : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreenMidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_screen_mid)
        binding = ActivityTutorialScreenMidBinding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right)

        binding.btnNext.setOnClickListener {
            val intent = Intent(applicationContext, TutorialScreenEnd::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvSkip.setOnClickListener {
            val intent = Intent(applicationContext, AuthenticatorBaseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}