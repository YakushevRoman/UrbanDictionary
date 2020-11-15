package com.example.test_jav_with_kotlin.models

import androidx.room.*
import com.example.test_jav_with_kotlin.data_base.type_conventers.SoundsConverter

@Entity(tableName = "search_table")
data class Search(
        @PrimaryKey(autoGenerate = true)
        val primaryKey: Int,
        val definition: String,
        val permalink: String,
        val thumbs_up: Int,
        @TypeConverters(SoundsConverter::class)
        val sound_urls: List<String>,
        val author: String,
        val defid: Int,
        val current_vote: String,
        val written_on: String,
        val example: String,
        val thumbs_down: Int
)