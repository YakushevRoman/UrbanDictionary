package com.example.test_jav_with_kotlin.app

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.example.test_jav_with_kotlin.R
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var api: UrbanDictionaryServiceApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UrbanApplication.component.inject(this)
        Log.d("TAG", "onCreateView:2 ")
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this@MainActivity, R.id.my_nav_host_fragment).navigateUp()
    }
}