package com.example.test_jav_with_kotlin.app.di

import com.example.test_jav_with_kotlin.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface UrbanDictionaryComponent {
    fun inject (mainActivity: MainActivity)
}