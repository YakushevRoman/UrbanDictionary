package com.example.test_jav_with_kotlin.di

import com.example.test_jav_with_kotlin.app.activities.MainActivity
import com.example.test_jav_with_kotlin.app.fragments.history_fragment.HistoryFragment
import com.example.test_jav_with_kotlin.app.fragments.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RetrofitModule::class,
    AdaptersModule::class,
    ApplicationContextModule::class,
    RoomModule::class
])
interface UrbanDictionaryComponent {
    fun inject (searchFragment: SearchFragment)
    fun inject (mainActivity: MainActivity)
    fun inject (historyFragment: HistoryFragment)
}