package com.example.restaurantmanagement.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import com.example.restaurantmanagement.MainActivity
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityLoginBinding
import com.example.restaurantmanagement.menulist.Menu
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.login_activity)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding.baselayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }

        loginAuthentication()
    }

    private fun loginAuthentication() {

        binding.etEmail.doOnTextChanged { text, _, _, _ ->
            checkTextExistence(text.toString(), binding.tiEmail)
        }

        binding.etPassword.doOnTextChanged { text, _, _, _ ->
            checkTextExistence(text.toString(), binding.tiPassword)
        }

        binding.etEmail.doOnTextChanged { text, _, _, _ ->
            if (text != "") {
                binding.tiEmail.error = null
            }
        }

        binding.etPassword.doOnTextChanged { text, _, _, _ ->
            if (text != "") {
                binding.tiPassword.error = null
            }
        }

        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.toString() == "" || binding.etPassword.text.toString() == "") {
                binding.tiEmail.error = getString(R.string.txt_required)
                binding.tiPassword.error = getString(R.string.txt_required)
            }
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()) {
                binding.tiEmail.error = getString(R.string.txt_invalid_email)
            }
            else {
                goToHome()
            }
        }

        binding.tvSignup.setOnClickListener {
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkTextExistence(text: String, view: TextInputLayout) {
        if (text != "") {
            view.error = null
        }
    }

    private fun goToHome() {
        val intent = Intent(applicationContext,BottomNavigation::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}