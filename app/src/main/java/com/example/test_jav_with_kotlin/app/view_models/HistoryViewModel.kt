package com.example.test_jav_with_kotlin.app.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.models.SearchList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HistoryViewModel(private val searchDao: SearchDao) : ViewModel() {

    fun getHistorySearch() : LiveData<List<SearchList>> = searchDao.getAllResultSearch()


}