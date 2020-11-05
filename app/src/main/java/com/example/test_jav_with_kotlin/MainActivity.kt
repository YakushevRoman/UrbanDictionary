package com.example.test_jav_with_kotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var api: UrbanDictionaryServiceApi

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        UrbanApplication.component.inject(this)
    }
}