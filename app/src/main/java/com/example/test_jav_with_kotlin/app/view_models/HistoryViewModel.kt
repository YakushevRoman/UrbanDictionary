package com.example.test_jav_with_kotlin.app.view_models

import androidx.lifecycle.ViewModel
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao

class HistoryViewModel : ViewModel() {
    private lateinit var searchDao: SearchDao

    fun setApi (searchDao: SearchDao){
        this.searchDao = searchDao
    }

}