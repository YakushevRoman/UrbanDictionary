package com.example.test_jav_with_kotlin.di

import com.example.test_jav_with_kotlin.app.adapters.HistorySearchAdapter
import com.example.test_jav_with_kotlin.app.adapters.SearchResultAdapter
import com.example.test_jav_with_kotlin.app.adapters.adapter_callback.HistorySearchItemClick
import com.example.test_jav_with_kotlin.models.SearchList
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdaptersModule {
    @Singleton
    @Provides
    fun getSearchAdapter() : SearchResultAdapter = SearchResultAdapter()

    /*@Provides
    @Singleton
    fun getHistorySearchAdapter() : HistorySearchAdapter = HistorySearchAdapter()*/


}