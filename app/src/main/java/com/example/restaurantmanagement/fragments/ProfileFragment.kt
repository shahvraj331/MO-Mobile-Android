package com.example.restaurantmanagement.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.restaurantmanagement.R
import com.example.restaurantmanagement.activities.BottomNavigation
import com.example.restaurantmanagement.activities.Login
import com.example.restaurantmanagement.activities.ResetPassword
import com.example.restaurantmanagement.activities.SessionManager
import com.example.restaurantmanagement.databinding.FragmentHomeBinding
import com.example.restaurantmanagement.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    lateinit var session: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        goToResetPassword()
        session = SessionManager(requireActivity())
        val view = binding.root
        return view
    }

    private fun goToResetPassword() {
        binding.btnResetPass.setOnClickListener {
            val intent = Intent(requireContext(), ResetPassword::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            session.logOutUser()
            val i = Intent(requireContext(), Login::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

    }

}