package com.example.test_jav_with_kotlin.app.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.UrbanApplication
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.di.ApplicationContextModule
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UrbanApplication.component.inject(this)
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return
        setUpBottomNav(host.navController)
    }

    private fun setUpBottomNav(navController: NavController) {
        findViewById<BottomNavigationView>(R.id.navigationView)?.setupWithNavController(navController)
    }
}