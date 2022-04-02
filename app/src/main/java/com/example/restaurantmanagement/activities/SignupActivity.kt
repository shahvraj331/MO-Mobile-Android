package com.example.restaurantmanagement.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.sign_up_activity)
        actionBar?.setDisplayHomeAsUpEnabled(true)

       binding.baselayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }

        onTextChanged(binding.etUsername, binding.tiUsername)
        onTextChanged(binding.etEmail, binding.tiEmail)
        onTextChanged(binding.etPassword,binding.tiPassword)

        binding.btnSignup.setOnClickListener {
            navigateToLogin()
        }

        binding.btnSignup.setOnClickListener {
            validation()
        }

        binding.tvSignin.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    private fun validation() {
        if (binding.etUsername.text.toString() == "" || binding.etEmail.text.toString() == "" || binding.etPassword.text.toString() == "" ) {
            binding.tiEmail.error = getString(R.string.txt_required)
            binding.tiUsername.error = getString(R.string.txt_required)
            binding.tiPassword.error = getString(R.string.txt_required)
        } else if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches() ) {
            binding.tiEmail.error = getString(R.string.txt_invalid_email)
        } else {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun checkTextExistence(text: String, view: TextInputLayout) {
        if (text != "") {
            view.error = null
        }
    }

    private fun onTextChanged(view: EditText, viewLayout: TextInputLayout) {
        view.doOnTextChanged { text, _, _, _ ->
            checkTextExistence(text.toString(), viewLayout)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}