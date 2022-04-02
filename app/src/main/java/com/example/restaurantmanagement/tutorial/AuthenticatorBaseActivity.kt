package com.example.restaurantmanagement.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.activities.SignupActivity
import com.example.restaurantmanagement.databinding.ActivityAuthenticatorBaseBinding

class AuthenticatorBaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticatorBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticatorBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        overridePendingTransition(R.anim.slid_left, R.anim.slide_right)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this@AuthenticatorBaseActivity, Login::class.java)
            startActivity(intent)
        }
        
        binding.btnSignup.setOnClickListener { 
            val intent = Intent(this@AuthenticatorBaseActivity, SignupActivity::class.java)
            startActivity(intent)
        }
    }

}