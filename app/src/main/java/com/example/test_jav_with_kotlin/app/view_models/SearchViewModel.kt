package com.example.test_jav_with_kotlin.app.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_jav_with_kotlin.models.Search
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel : ViewModel() {
    private lateinit var urbanDictionaryServiceApi: UrbanDictionaryServiceApi

    private val _searchList= MutableLiveData<List<Search>>()
    val searchList: LiveData<List<Search>> = _searchList


    fun setApi (urbanDictionaryServiceApi: UrbanDictionaryServiceApi){
        this.urbanDictionaryServiceApi = urbanDictionaryServiceApi
    }

    fun getSearchList (searchWord : String){
        urbanDictionaryServiceApi.getListOfWords(searchWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _searchList.value = it.list
                },{
                    it.printStackTrace()
                })
    }

}