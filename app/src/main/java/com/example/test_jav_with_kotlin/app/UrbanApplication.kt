package com.example.test_jav_with_kotlin.app

import android.app.Application
import android.util.Log
import com.example.test_jav_with_kotlin.app.di.DaggerUrbanDictionaryComponent
import com.example.test_jav_with_kotlin.app.di.RetrofitModule
import com.example.test_jav_with_kotlin.app.di.UrbanDictionaryComponent

class UrbanApplication : Application() {
    companion object {
        lateinit var component : UrbanDictionaryComponent
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreateView:1 ")

        initDaggerComponent()
    }

    private fun initDaggerComponent(){
        component = DaggerUrbanDictionaryComponent
                .builder()
                .retrofitModule(RetrofitModule())
                .build();
    }

}