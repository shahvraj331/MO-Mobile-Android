package com.example.restaurantmanagement.tableBooking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.restaurantmanagement.R

class DummyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)
        val fragment = DineInFragment()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
    }
}