package com.example.test_jav_with_kotlin.app.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.models.Search
import com.example.test_jav_with_kotlin.models.SearchList
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private lateinit var urbanDictionaryServiceApi: UrbanDictionaryServiceApi
    private lateinit var searchDao: SearchDao


    private val _searchList = MutableLiveData<List<Search>>()
    val searchList: LiveData<List<Search>> = _searchList
    private var _lastWord: MutableLiveData<String> = MutableLiveData<String>()
    var lastWord: LiveData<String> = _lastWord
    lateinit var listSearchData: LiveData<List<SearchList>>


    fun setApi (urbanDictionaryServiceApi: UrbanDictionaryServiceApi, searchDao: SearchDao){
        this.searchDao = searchDao
        this.urbanDictionaryServiceApi = urbanDictionaryServiceApi
        listSearchData = searchDao.getAllResultSearch()
    }

    fun getSearchList (searchWord : String){
        urbanDictionaryServiceApi
                .getListOfWords(searchWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _searchList.value = it.list
                    _lastWord.value = searchWord
                    it.searchWord = searchWord
                    GlobalScope.launch {
                        searchDao.insertSearch(it)
                    }
                }, {
                    it.printStackTrace()
                })
    }

}