package com.example.restaurantmanagement.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.sign_up_activity)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding.baseLayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }

        onTextChanged(binding.etUsername, binding.tlUsername)
        onTextChanged(binding.etEmail, binding.tlEmail)
        onTextChanged(binding.etPassword,binding.tlPassword)
        onTextChanged(binding.etConfirmPassword, binding.tlConfirmPassword)

        binding.tvGoToSignin.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            validation()
        }
    }

    private fun validation() {
        if (binding.etUsername.text.toString() == "" || binding.etEmail.text.toString() == "" || binding.etPassword.text.toString() == "" || binding.etConfirmPassword.text.toString() == "") {
            binding.tlEmail.error = getString(R.string.txt_required)
            binding.tlUsername.error = getString(R.string.txt_required)
            binding.tlPassword.error = getString(R.string.txt_required)
            binding.tlConfirmPassword.error = getString(R.string.txt_required)
        } else if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches() ){
            binding.tlEmail.error = getString(R.string.txt_invalid_email)
        } else if ( binding.etPassword.text.toString() != binding.etConfirmPassword.text.toString()) {
            binding.tlConfirmPassword.error = getString(R.string.txt_password_mismatch)
        } else {
            val intent = Intent(this, SignupActivity::class.java)
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