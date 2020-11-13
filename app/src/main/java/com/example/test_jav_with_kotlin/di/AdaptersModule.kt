package com.example.test_jav_with_kotlin.di

import com.example.test_jav_with_kotlin.app.adapters.SearchResultAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdaptersModule {
    @Singleton
    @Provides
    fun getSearchAdapter() : SearchResultAdapter =
            SearchResultAdapter()
}