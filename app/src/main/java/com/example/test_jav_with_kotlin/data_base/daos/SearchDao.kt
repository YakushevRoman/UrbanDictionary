package com.example.test_jav_with_kotlin.data_base.daos

import androidx.room.*
import com.example.test_jav_with_kotlin.models.Search
import io.reactivex.rxjava3.core.Observable

@Dao
interface SearchDao  {
    @Insert
    fun insertSearch(list :List<Search>) : Int

    @Query ("select * from Search where :time")
    fun getLastSearchResult (time : Long)  : Long
}