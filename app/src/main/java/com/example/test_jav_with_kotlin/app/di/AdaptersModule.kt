package com.example.test_jav_with_kotlin.app.di

import com.example.test_jav_with_kotlin.app.adapters.SearchResultAdapter
import dagger.Module
import dagger.Provides

@Module
class AdaptersModule {
    @Provides
    fun getSearchAdapter() : SearchResultAdapter = SearchResultAdapter()
}