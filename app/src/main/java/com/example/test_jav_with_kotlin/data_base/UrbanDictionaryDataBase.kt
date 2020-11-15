package com.example.test_jav_with_kotlin.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import com.example.test_jav_with_kotlin.data_base.type_conventers.SearchConverter
import com.example.test_jav_with_kotlin.data_base.type_conventers.SoundsConverter
import com.example.test_jav_with_kotlin.models.Search
import com.example.test_jav_with_kotlin.models.SearchList

@Database(
        entities = [Search::class, SearchList::class],
        version = RoomSettings.version,
        exportSchema = RoomSettings.exportSchema
)
@TypeConverters(SoundsConverter::class, SearchConverter::class)
abstract class UrbanDictionaryDataBase : RoomDatabase() {
     abstract fun getSearchDao() : SearchDao
}