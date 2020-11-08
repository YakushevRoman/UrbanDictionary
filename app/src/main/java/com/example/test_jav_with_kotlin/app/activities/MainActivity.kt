package com.example.test_jav_with_kotlin.app.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.UrbanApplication
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.di.ApplicationContextModule
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var api: UrbanDictionaryServiceApi
    @Inject lateinit var searchDao: SearchDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UrbanApplication.component.inject(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this@MainActivity, R.id.my_nav_host_fragment).navigateUp()
    }
}