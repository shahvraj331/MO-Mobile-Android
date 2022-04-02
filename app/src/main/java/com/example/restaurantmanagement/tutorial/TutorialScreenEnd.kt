package com.example.restaurantmanagement.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityTutorialScreenEndBinding

class TutorialScreenEnd : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreenEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialScreenEndBinding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnNext.setOnClickListener {
            val intent = Intent(applicationContext, AuthenticatorBaseActivity::class.java)
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