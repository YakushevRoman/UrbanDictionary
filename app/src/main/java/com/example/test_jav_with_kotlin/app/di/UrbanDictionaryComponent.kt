package com.example.test_jav_with_kotlin.app.di

import com.example.test_jav_with_kotlin.app.MainActivity
import com.example.test_jav_with_kotlin.app.fragments.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, AdaptersModule::class])
interface UrbanDictionaryComponent {
    fun inject (searchFragment: SearchFragment)
    fun inject (mainActivity: MainActivity)
}