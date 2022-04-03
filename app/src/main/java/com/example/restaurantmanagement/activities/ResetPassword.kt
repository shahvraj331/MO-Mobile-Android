package com.example.restaurantmanagement.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityForgotPasswordBinding
import com.example.restaurantmanagement.databinding.ActivityResetPasswordBinding
import com.google.android.material.textfield.TextInputLayout

class ResetPassword : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionEvents()
    }

    private fun actionEvents() {
        binding.etConfirmPassword.doOnTextChanged { _, _, _, _ ->
            if (binding.etPassword.text.toString() == "" || binding.etConfirmPassword.text.toString() == "") {
                binding.tiPassword.error = getString(R.string.txt_required)
                binding.tiConfirmPassword.error = getString(R.string.txt_required)
            }
            else if (binding.etPassword.text.toString() !=  binding.etConfirmPassword.text.toString()) {
                binding.tiConfirmPassword.error = getString(R.string.txt_password_mismatch)
            }
            else {
                binding.tiPassword.error = null
                binding.tiConfirmPassword.error = null
            }
        }
        binding.btnChange.setOnClickListener {
            validation()
        }
    }

    private fun validation() {
            if (binding.etPassword.text.toString() == "" || binding.etConfirmPassword.text.toString() == "") {
                binding.tiPassword.error = getString(R.string.txt_required)
                binding.tiConfirmPassword.error = getString(R.string.txt_required)
            }
            else if (binding.etPassword.text.toString() !=  binding.etConfirmPassword.text.toString()) {
                binding.tiConfirmPassword.error = getString(R.string.txt_password_mismatch)
            }
            else {
                binding.tiPassword.error = null
                binding.tiConfirmPassword.error = null
                var intent = Intent(this, Login::class.java)
                startActivity(intent)
            }
        }
}