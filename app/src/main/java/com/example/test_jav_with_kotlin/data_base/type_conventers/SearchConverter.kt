package com.example.test_jav_with_kotlin.data_base.type_conventers

import androidx.room.TypeConverter
import com.example.test_jav_with_kotlin.models.Search
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SearchConverter {

    @TypeConverter
    fun toSounds(value: List<Search>): String {
        val type = object : TypeToken<List<Search>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun fromSounds(value: String): List<Search> {
        val type = object : TypeToken<List<Search>>() {}.type
        return Gson().fromJson(value, type)
    }
}