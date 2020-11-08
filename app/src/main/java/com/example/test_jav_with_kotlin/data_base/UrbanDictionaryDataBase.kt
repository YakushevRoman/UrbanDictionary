package com.example.test_jav_with_kotlin.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.models.Search

@Database(entities = [Search::class], version = 1, exportSchema = false)
abstract class UrbanDictionaryDataBase : RoomDatabase() {
     abstract fun getSearchDao() : SearchDao
}