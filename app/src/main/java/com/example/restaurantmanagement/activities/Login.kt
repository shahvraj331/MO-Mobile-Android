package com.example.restaurantmanagement.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

import com.example.restaurantmanagement.MainActivity
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.databinding.ActivityLoginBinding
import com.example.restaurantmanagement.tutorial.TutorialScreenEnd
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import webServices.APIClient
import webServices.PostData
import webServices.PostResponseData

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var session: SessionManager
    lateinit var pre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pre = getSharedPreferences("KOtlinDemo", MODE_PRIVATE)
        session = SessionManager(applicationContext)

        if(session.isLogin()) {
            val i = Intent(applicationContext, BottomNavigation::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.login_activity)
        actionBar?.setDisplayHomeAsUpEnabled(true)
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
            checkTextExistence(text.toString(), binding.tiEmail)
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
                postData(PostData(binding.etEmail.text.toString(), binding.etPassword.text.toString()))
            }
        }

    }

    private fun checkTextExistence(text: String, view: TextInputLayout) {
        if (text != "") {
            view.error = null
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    fun postData(data: PostData) {
        val retrofitData = APIClient.retrofitBuilder.loginApi(
            data.email, data.password
        )
        retrofitData.enqueue(object: Callback<Unit>{
            override fun onResponse(
                call: Call<Unit>,
                response: Response<Unit>
            ) {
                if (response.code() == 200) {
                    session.createLoginSession(binding.etEmail.text.toString())
                    val intent = Intent(this@Login, BottomNavigation::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                } else {
                    Log.d("failure",response.code().toString())
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("failure","Failed to load url")
            }
        })
    }

}