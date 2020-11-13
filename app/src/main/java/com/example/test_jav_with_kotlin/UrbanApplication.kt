package com.example.test_jav_with_kotlin

import android.app.Application
import android.util.Log
import com.example.test_jav_with_kotlin.di.*

class UrbanApplication : Application() {
    companion object {
        lateinit var component : UrbanDictionaryComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDaggerComponent()
    }

    private fun initDaggerComponent(){
        component = DaggerUrbanDictionaryComponent
                .builder()
                .retrofitModule(RetrofitModule())
                .adaptersModule(AdaptersModule())
                .applicationContextModule(ApplicationContextModule(this))
                .roomModule(RoomModule())
                .build();
    }

}