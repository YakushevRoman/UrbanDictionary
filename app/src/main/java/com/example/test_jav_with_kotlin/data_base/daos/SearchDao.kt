package com.example.test_jav_with_kotlin.data_base.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.test_jav_with_kotlin.data_base.type_conventers.SoundsConverter
import com.example.test_jav_with_kotlin.models.SearchList
import io.reactivex.rxjava3.core.Single


@Dao
interface SearchDao  {
    @Insert
    suspend fun insertSearch(searchResult: SearchList)

    @Query("Select * From results_search_table")
    fun getAllResultSearch() : LiveData<List<SearchList>>

}