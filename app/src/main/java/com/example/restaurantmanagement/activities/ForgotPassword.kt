package com.example.restaurantmanagement.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityForgotPasswordBinding
import com.google.android.material.textfield.TextInputLayout

class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            emailValidation()
        }

    }

    private fun emailValidation() {
            if (binding.etEmail.text?.isEmpty() == true) {
                binding.tiEmail.error = getString(R.string.txt_required)
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches() ){
                binding.tiEmail.error = getString(R.string.txt_invalid_email)
            }
            else {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }
        }

}